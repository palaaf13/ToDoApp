package com.axelpalacios.todoapp;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AddController {
    //Attributes
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private ChoiceBox<Integer> priorityChoiceBox;


    private Controller mainController;

    @FXML
    public void initialize(){
        priorityChoiceBox.getItems().addAll(1,2,3,4,5);
        priorityChoiceBox.setValue(3);
    }

    public void setMainController(Controller controller) {
        this.mainController = controller;
    }

    //Handling "Save and Close" button so that text field inputs are actually saved/displayed
    public void handleClose(javafx.event.ActionEvent event) {
        String title = titleTextField.getText();
        String description = descriptionTextField.getText();

        if (mainController != null) {
            int priority = priorityChoiceBox.getValue();
            mainController.addToDo(new ToDo(title, description, priority));
        }
        //after button is clicked, close window and go back to ToDo List
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
