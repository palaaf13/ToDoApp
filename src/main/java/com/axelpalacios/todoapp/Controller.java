package com.axelpalacios.todoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private ListView<ToDo> toDoList;
    @FXML
    private Label titleLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    public void initialize(){

        toDoList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null){
                titleLabel.setVisible(true);
                descriptionLabel.setVisible(true);
                titleLabel.setText(newSelection.getTitle());
                descriptionLabel.setText(newSelection.getDescription());
            }
        });
    }
    @FXML
    private void openNewWindow() {
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
