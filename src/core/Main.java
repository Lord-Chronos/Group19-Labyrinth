package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Labyrinth - Group 19");
        stage.setResizable(false);
        stage.show();
    }

    public static void changeScene(String fxmlPath, String title) {
        Scene scene;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(new URL("file:./../" + fxmlPath));
            scene = new Scene(root);
            stage.hide();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            showError("The program could not find the FXML file of this window.", "Error Displaying Window",
                    "Error", true);
        }
    }

    public void showConformation(String msg, String heading, String title) {
//
    }

    /**
     * Displays an Error Dialog containing the passed messages
     * @param msg Message to be displayed
     * @param heading The Heading to be displayed
     * @param title The title of the dialog box window
     */
    public static void showError(String msg, String heading, String title, boolean exit) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(heading);
        alert.setContentText(msg);
        alert.showAndWait();
        if (exit) {System.exit(0); };
    }
}
