package com.axelpalacios.todoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller {
    @FXML
    private ListView<ToDo> toDoList;
    @FXML
    private Label titleLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    public void initialize(){
        toDoList.getItems().addAll(
                new ToDo("Homework", "Module 4 Lab CSC311")
        );

        toDoList.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null){
                titleLabel.setVisible(true);
                descriptionLabel.setVisible(true);
                titleLabel.setText(newSelection.getTitle());
                descriptionLabel.setText(newSelection.getDescription());
            }
        });
    }
}
