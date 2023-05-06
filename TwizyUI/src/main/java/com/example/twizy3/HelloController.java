package com.example.twizy3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        System.out.println("test");
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}