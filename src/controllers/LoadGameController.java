package controllers;

import static controllers.StageController.home;
import static controllers.StageController.showError;

import constants.ErrorMessage;
import constants.Title;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * Controls and handles the LoadGame scene
 *
 * @author Joseph Omar
 * @version 1.0
 */
public class LoadGameController implements Initializable {

   private static final Title title = Title.SAVE;
   @FXML
   private Button cmdRefresh;
   @FXML
   private Button cmdLoad;
   @FXML
   private Button cmdCancel;
   @FXML
   private ListView<File> lstSaves;

   private File selected;

   /**
    * refreshes the list content
    *
    * @param actionEvent
    */
   public void cmdRefreshClick(ActionEvent actionEvent) {
      setListData();
   }

   /**
    * Sets the collection of items that is shown on the listbox to the list generated by getSaves()
    */
   private void setListData() {
      ObservableList<File> observableList =
           FXCollections.observableList(getSaves());
      lstSaves.setItems(observableList);
   }

   /**
    * Finds all the files in the save folder that have the extension .labyrinth and adds them to a
    * list
    *
    * @return List of save files
    */
   private List<File> getSaves() {
      File dir = new File("/../saves");
      if (!dir.exists()) {
         dir.mkdir();
      }
      File[] dirFilteredContents =
           dir.listFiles((dir1, name) -> name.endsWith(".labyrinth"));
      return Arrays.asList(Objects.requireNonNull(dirFilteredContents));
   }

   /**
    * Handles the event that occurs when a list item is selected
    *
    * @param mouseEvent
    */
   public void lstSavesClick(MouseEvent mouseEvent) {
      selected = lstSaves.getSelectionModel().getSelectedItem();
   }

   /**
    * Handles the event that occurs when load game is clicked. It checks if an item is selected and
    * if it is, sends the selected save file to the Logic class
    *
    * @param actionEvent
    */
   public void cmdLoadClick(ActionEvent actionEvent) {
      if (selected == null &&
           lstSaves.getSelectionModel().getSelectedItem() == null) {
         showError(ErrorMessage.SAVE_NOT_SELECTED, title, false);
      } else {
         /*TODO Make the game */
      }
   }

   /**
    * goes back to the main menu
    *
    * @param actionEvent
    */
   public void cmdCancelClick(ActionEvent actionEvent) {
      home();
   }

   @Override
   public void initialize(URL location, ResourceBundle resources) {
        /*
        lstSaves.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        getSaves();
        setListData();
        */
   }
}
