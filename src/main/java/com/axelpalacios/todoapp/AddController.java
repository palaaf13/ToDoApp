package com.axelpalacios.todoapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AddController {
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField descriptionTextField;

    private Controller mainController;

    public void setMainController(Controller controller) {
        this.mainController = controller;
    }

    public void handleClose(javafx.event.ActionEvent event) {
        String title = titleTextField.getText();
        String description = descriptionTextField.getText();

        if (mainController != null) {
            mainController.addToDo(new ToDo(title, description));
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
