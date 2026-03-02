package com.axelpalacios.todoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.stage.Stage;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.DragEvent;


public class Controller {
    //Attribute declarations
    @FXML
    private ListView<ToDo> toDoList;
    @FXML
    private Label titleLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label titleTitleLabel;
    @FXML
    private Label descriptionDescriptionLabel;
    @FXML
    private ImageView trashBin;
    @FXML
    private ImageView trashBinFull;
    @FXML
    private Label trashBinBlankLabel;


    @FXML
    public void initialize() {
        //List item selection to show title and description
        toDoList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                titleTitleLabel.setVisible(true);
                descriptionDescriptionLabel.setVisible(true);
                titleLabel.setVisible(true);
                descriptionLabel.setVisible(true);
                titleLabel.setText(newSelection.getTitle());
                descriptionLabel.setText(newSelection.getDescription());
            }
        });


        //trash bin function code (deleting reminders)
        toDoList.setOnDragDetected(event -> {
            ToDo selectedItem = toDoList.getSelectionModel().getSelectedItem();

            if (selectedItem == null) return;

            Dragboard db = toDoList.startDragAndDrop(javafx.scene.input.TransferMode.MOVE);

            javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
            content.putString(selectedItem.getTitle());
            db.setContent(content);

            event.consume();
        });


        trashBinBlankLabel.setOnDragOver(event -> {
            if (event.getGestureSource() != trashBinBlankLabel &&
                    event.getDragboard().hasString()) {
                event.acceptTransferModes(javafx.scene.input.TransferMode.MOVE);
            }
            event.consume();
        });


        trashBinBlankLabel.setOnDragDropped(event -> {

            ToDo selectedItem = toDoList.getSelectionModel().getSelectedItem();

            if (selectedItem != null) {
                toDoList.getItems().remove(selectedItem);
            }

            //Changes trash bin visualization from empty to full (two different sprites stacked)
            trashBin.setVisible(false);
            trashBinFull.setVisible(true);

            //Disable visibily on title and description attributes after deleting item from list
            titleTitleLabel.setVisible(false);
            titleLabel.setVisible(false);
            descriptionDescriptionLabel.setVisible(false);
            descriptionLabel.setVisible(false);

            event.setDropCompleted(true);
            event.consume();
        });
    }

    //Add window
    @FXML
    private void openNewWindow() {
        //for when "Add" button is clicked aka opening a new window (addItem.fxml)
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("addItem.fxml")
            );

            Scene scene = new Scene(loader.load());

            AddController controller = loader.getController();
            controller.setMainController(this);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addToDo(ToDo todo) {
        toDoList.getItems().add(todo);
    }
}
