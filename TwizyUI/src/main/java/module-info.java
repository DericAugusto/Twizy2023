module com.example.twizy3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.twizy3 to javafx.fxml;
    exports com.example.twizy3;
}