module edu.farmingdale.regex {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.regex to javafx.fxml;
    exports edu.farmingdale.regex;
}