module com.example.bandforge {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.bandforge to javafx.fxml;
    opens com.bandforge.controller to javafx.fxml;

    exports com.bandforge;
    exports com.bandforge.controller;
}