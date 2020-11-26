package fxml;

import core.ErrorMsg;
import core.Main;
import core.Title;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import players.PlayerProfile;
import players.Profiles;

import java.util.ArrayList;
import java.util.Optional;

import static fxml.StageController.previousScene;
import static fxml.StageController.*;

public class ScoreboardController {
    @FXML
    private TableView tblTable;
    @FXML
    private TableColumn<PlayerProfile, String> colNickname;
    @FXML
    private TableColumn<PlayerProfile, Integer> colGames;
    @FXML
    private TableColumn<PlayerProfile, Integer> colWins;
    @FXML
    private TableColumn<PlayerProfile,Integer> colLosses;
    @FXML
    private TableColumn<PlayerProfile, Double> colPercentage;
    @FXML
    private Button cmdBack;

    /**
     * Goes back to the main menu
     * @param actionEvent
     */
    public void cmdBackClick(ActionEvent actionEvent) {
        home();
    }

    /**
     * Initialises a Scoreboard
     */
    public ScoreboardController() {
        ArrayList<PlayerProfile> profiles = null;
        try {
            profiles = Profiles.get();
        } catch (Exception e) {
            showError(ErrorMsg.PROFILE_LOAD_ERROR, Title.SCOREBOARD, false);
            home();
        } finally {
            if (profiles == null) {
                nullListHandler();
            } else {
                populate(profiles);
            }
        }
    }

    /**
     * Handles the if the profiles list read in is null
     */
    private void nullListHandler() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "There are no profiles to display, would you like to create one?", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("No Profile Data");
        alert.setTitle("Scoreboard");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES) {
            Profiles.addProfileDialog();
        } else {
             home();
        }
    }

    /**
     * Populates the scoreboard with profiles
     * @param profiles Profiles to be added to the scoreboard table
     */
    private void populate(ArrayList<PlayerProfile> profiles) {
        colNickname.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        colGames.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getNumOfGames()).asObject());
        colWins.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getNumOfWins()).asObject());
        colLosses.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getNumOfLosses()).asObject());
        colPercentage.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getWinPercentage()).asObject());
        tblTable.getItems().addAll(profiles);
    }

}
