package controllers;

import static controllers.StageController.changeScene;
import static controllers.StageController.showError;

import constants.Angle;
import constants.ErrorMsg;
import constants.TileType;
import constants.Title;
import constants.Window;
import core.Gameboard;
import core.Level;
import core.Save;
import holdables.Effect;
import holdables.Holdable;
import holdables.PlayerEffect;
import holdables.Tile;
import holdables.TileEffect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import players.Player;
import players.PlayerMovement;
import styles.Style;

/**
 * TODO Test Drawing Draw Players test move dialog make apply effects work method to apply effect to
 * a player events for selected effect image, draw a border? maybe listview? logic for activate
 */
public class GameboardController
        implements InitialisableWithParameters {

    private static final int TILE_SIZE = 80;
    private static final double WINDOW_HEIGHT = 34;
    private static final double WINDOW_WIDTH = 340;

    private static final String FORMATTING_PLAYERS =
            "Formatting Players";
    private static final String PLAYER_FORMATTING_COMPLETE =
            "Player Formatting Complete!";
    private static final String SILK_BAG_DRAW =
            "Draw from silk bag";
    private static final String PLACE_TILE =
            "Place your tile";

    private static final String REFRESHING =
            "Refreshing Gameboard";
    private static final String REFRESH_COMPLETE =
            "Refreshing Gameboard";
    @FXML
    private BorderPane root;
    @FXML
    private GridPane grdBoard;
    @FXML
    private VBox vboxPlayers;
    @FXML
    private ListView<String> lstEffects;
    @FXML
    private Button cmdActivate;
    @FXML
    private Label lblStatus;
    @FXML
    private Button cmdSilkBag;


    private ArrayList<Player> players;

    private Style style;

    private Level level;
    private Gameboard gameboard;

    private int tempPlayerCounter = 0;

    private Holdable newTileToPlace;
    private PlayerMovement playerMovement;
    private Player activePlayer;
    private boolean playerMoving;
    private int activePlayerMovementLeft = 4;

    /**
     * Called from the {@link StageController}, allows the passage of parameters between scenes
     *
     * @param parameters Parameters for this Controller
     */
    @Override
    public void initialiseWithParameters(Object[] parameters, Scene scene, Stage stage) {
        this.gameboard = (Gameboard) parameters[0];
        setGridSize(gameboard.getWidth(), gameboard.getHeight());
        playerMovement = new PlayerMovement(gameboard);
        refresh();
        formatPlayers();
        startKeyListener(scene);
        activePlayer = players.get(tempPlayerCounter);
        //playerTurn();

    }
    /**
     * Creates a Container that holds the player and their data
     *
     * @param player Player to create a Container for
     * @return Formatted Vbox
     */
    private static VBox createPlayerContainer(Player player) {
        ImageView image = new ImageView(player.getPlayerImage());
        image.setPreserveRatio(false);
        image.setFitHeight(TILE_SIZE);
        image.setFitWidth(TILE_SIZE);
        Label name = new Label(player.getProfile().getName());
        VBox playerPicture = new VBox(image, name);
        playerPicture.setMaxWidth(TILE_SIZE);
        VBox.setMargin(image, new Insets(4, 0, 4, 0));
        VBox.setMargin(name, new Insets(4, 4, 4, 4));
        return playerPicture;
    }

    public void cmdActionClick(MouseEvent mouseEvent) {

    }

    /**
     * Places players at new coordinates
     *
     * @param pList List of players to place
     */
    private void placePlayer(ArrayList<Player> pList) {
        for (Player player : pList) {
            placePlayer(player);
        }
    }

    /**
     * Places single player at new coordinate
     *
     * @param p Player to place
     */
    private void placePlayer(Player p) {
        ImageView image = new ImageView(p.getPlayerImage());
        image.setPreserveRatio(false);
        image.setFitHeight(TILE_SIZE);
        image.setFitWidth(TILE_SIZE);
        grdBoard.add(image, p.getCoordinate().getX(), p.getCoordinate().getY());
    }


    /**
     * Formats each player and adds them to the left panel of the board window
     */
    private void formatPlayers() {
        setStatus(FORMATTING_PLAYERS);
        this.vboxPlayers.setAlignment(Pos.CENTER);
        players = new ArrayList<>(this.gameboard.getPlayers());
        players.forEach(player -> {
            VBox playerPicture = createPlayerContainer(player);
            this.vboxPlayers.getChildren().add(playerPicture);
        });
        setStatus(PLAYER_FORMATTING_COMPLETE);
    }

    /**
     * Sets the value of the status message
     *
     * @param message Message to be displayed
     */
    public void setStatus(String message) {
        this.lblStatus.setText(message);
    }

    /**
     * Gets the currently active Player
     *
     * @return Currently active player
     */
    public Player getActivePlayer() {
        return this.activePlayer;
    }

    /**
     * Sets the currently active player
     *
     * @param player Player to set as active
     */
    public void setActivePlayer(Player player) {
        this.activePlayer = player;
    }

    /**
     * playerturn order stuff
     */
    private void playerTurn() {
        // Draw from silk bag
        cmdActivate.setDisable(false);
        setStatus(SILK_BAG_DRAW);

      /*
      Logic
      Silk bag set to true
      Silk bag set to




       playerMoving = true;
       System.out.println("HELLO" );

      if (activePlayerMovementLeft == 0){
          playerMoving = false;
      }

        */

        // finish
        if (winCheck()) {
            //somehow end the game
        } else {
            tempPlayerCounter = iterateTempPlayerCounter();
            activePlayer = players.get(tempPlayerCounter);
            activePlayerMovementLeft = 4;

            refresh();
        }

    }

    /**
     * Adds each effect in the active player's hand to the listview of effects
     */
    public void displayPlayerHand() {
        ArrayList<String> hand = new ArrayList<>();
        activePlayer.getHand().forEach(item -> hand.add(item.toString()));
        lstEffects.getItems().setAll(hand);
    }



    /**
     * Sets up the correct number of rows and columns according to parameters
     *
     * @param width  Width in Columns
     * @param height Height in Columns
     */
    private void setGridSize(int width, int height) {
        this.grdBoard.getColumnConstraints().clear();
        this.grdBoard.getRowConstraints().clear();
        for (int i = 0; i < width; i++) {
            ColumnConstraints columnConstraint = new ColumnConstraints();
            columnConstraint.setPercentWidth(100.0 / width);
            this.grdBoard.getColumnConstraints().add(columnConstraint);
        }
        for (int i = 0; i < height; i++) {
            RowConstraints rowConstraint = new RowConstraints();
            rowConstraint.setPercentHeight(100.0 / height);
            this.grdBoard.getRowConstraints().add(rowConstraint);
        }
        setWindowSize();
    }

    /**
     * Refreshes the GridPane, updating each tile from the {@link Gameboard}
     */
    private void refresh() {
        if (gameboard != null) {
            setStatus(REFRESHING);
            gameboard.getTiles().forEach(tile -> {
                System.out.println(tile.toString());
                ImageView image = new ImageView();
                image.setImage(tile.getImage());
                image.setRotate(tile.getAngle().get());
                image.setPreserveRatio(false);
                image.setFitHeight(TILE_SIZE);
                image.setFitWidth(TILE_SIZE);
                grdBoard.add(image, tile.getCoordinate().getX(), tile.getCoordinate().getY());
                placePlayer(gameboard.getPlayers());
            });
            setStatus(REFRESH_COMPLETE);
        } else {
            showError(ErrorMsg.BOARD_REFRESH_ERROR, Title.CRIT_ERROR, false);
            changeScene(Window.SETUP);
        }
    }

    /**
     * Sets the height of the window based on the size of the gameboard
     */
    private void setWindowSize() {
        double gridPaneWidth =
                TILE_SIZE * grdBoard.getColumnConstraints().size();
        double gridPaneHeight =
                TILE_SIZE * grdBoard.getRowConstraints().size();
        grdBoard.setMaxSize(gridPaneWidth, gridPaneHeight);
        grdBoard.setMinSize(gridPaneWidth, gridPaneHeight);
        grdBoard.setPrefSize(gridPaneWidth, gridPaneHeight);

        root.setMaxSize(gridPaneWidth + WINDOW_WIDTH, gridPaneHeight + WINDOW_HEIGHT);
        root.setMinSize(gridPaneWidth + WINDOW_WIDTH, gridPaneHeight + WINDOW_HEIGHT);
        root.setPrefSize(gridPaneWidth + WINDOW_WIDTH, gridPaneHeight + WINDOW_HEIGHT);
    }

    public void drawTile() {
        setNewTileToPlace(gameboard.getSilkBag().getFirst());
    }

    public void setNewTileToPlace(Holdable newTileToPlace) {
        this.newTileToPlace = newTileToPlace;
    }

    /**
     * Handles the Activate button click event
     *
     * @param mouseEvent
     */
    public void cmdActivateClick(MouseEvent mouseEvent) {
        showTileShifts(new Tile(TileType.CORNER, this.style, Angle.UP, false), this.gameboard);
    }


    /**
     * Will work when goalTile is variable in gameboard
     *
     * @return
     */
    public boolean winCheck() {
        return gameboard.getTiles().get(activePlayer.getCoordinate()).getType()
                .equals(
                        TileType.GOAL);
    }

    private void startKeyListener(Scene scene) {
        scene.setOnKeyReleased(this::handleKeyPress);
    }

    private void handleKeyPress(KeyEvent event) {
        Player p = getActivePlayer();
        playerMoving = true;
        if (playerMoving && activePlayerMovementLeft > 0) {
            if (event.getCode().equals(KeyCode.ESCAPE)) {
                showExitDialog();
            } else if (event.getCode().isArrowKey()) {
                playerMovement.keyPressed(event.getCode(), p);
                activePlayerMovementLeft -= 1;

                refresh();
            }
        } else if (activePlayerMovementLeft == 0) {
            playerTurn();
        }
    }


    private void showExitDialog() {
        Scene scene = null;
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(StageController.class
                    .getResource(
                            Window.EXIT
                                    .getPath()));
            Parent root = loader.load();
            InitialisableWithParameters controller = loader.getController();
            scene = new Scene(root);
            controller.initialiseWithParameters(
                    new Object[]{this}, scene, stage);
            stage.setTitle(Title.MAIN.name());
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            showError(ErrorMsg.FXML_NOT_FOUND, Title.ERROR, false);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }


    /**
     * Saves the game and exits the application
     */
    public void saveAndExit() {
        try {
            Save.saveGame(new Object[]{gameboard, this, playerMovement});
            System.exit(0);
        } catch (IOException e) {
            showError(ErrorMsg.SAVE_WRITE_ERROR, Title.ERROR, false);
            e.printStackTrace();
        }
    }

    /**
     * Exits the application without saving
     */
    public void exit() {
        System.exit(0);
    }

    /**
     * Shows the Place Tile dialog
     *
     * @param tile Tile to place onto the board
     */
    public void showTileShifts(Tile tile, Gameboard gameboard) {
        Scene scene = null;
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(StageController.class
                    .getResource(
                            Window.TILE_SHIFT
                                    .getPath()));
            Parent root = loader.load();
            InitialisableWithParameters controller = loader.getController();
            scene = new Scene(root);
            controller.initialiseWithParameters(
                    new Object[]{tile, gameboard, this}, scene, stage);
            stage.setTitle(Title.MAIN.name());
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            showError(ErrorMsg.FXML_NOT_FOUND, Title.ERROR, false);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void lstEffectClick(MouseEvent mouseEvent) {
        lstEffects.getSelectionModel().getSelectedItem();
    }


    private void backTrackLim(Player targetPlayer, Player player) {
        if (!targetPlayer.hasBeenBackTracked()) {
            playerMovement.backMovement(targetPlayer);
            targetPlayer.setBeenBackTracked(true);
        }

        boolean everyoneBackTracked = true;
        for (Player gamePlayer : players) {
            if (!gamePlayer.hasBeenBackTracked()) {
                everyoneBackTracked = false;
            }
        }

        if (everyoneBackTracked) {
            player.getHand().removeAll(Collections.singleton(PlayerEffect.BACKTRACK));
            gameboard.getSilkBag().removeAll(Collections.singleton(PlayerEffect.BACKTRACK));
        }
    }

    public int iterateTempPlayerCounter() {
        if (tempPlayerCounter < this.gameboard.getPlayersCount()-1) {
            return tempPlayerCounter + 1;
        } else if (tempPlayerCounter == this.gameboard.getPlayersCount()) {
            return 0;
        } else {
            return 0;
        }
    }
}

