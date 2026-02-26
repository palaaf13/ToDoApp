module com.axelpalacios.todoapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.axelpalacios.todoapp to javafx.fxml;
    exports com.axelpalacios.todoapp;
}