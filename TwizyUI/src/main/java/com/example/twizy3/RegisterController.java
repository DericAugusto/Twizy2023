package com.example.twizy3;

import com.example.utils.database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.twizy3.Main;

public class RegisterController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField cpassword;
    @FXML
    private Label errorLabel;

    @FXML
    public void switchSceneToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void register(ActionEvent event) throws IOException, SQLException {

        ResultSet rs = Main.db.query("SELECT * FROM users WHERE username='" + username.getText() + "'");

        if(rs.next() == false && !username.getText().equals("")) {
            if(password.getText().equals(cpassword.getText()) && !password.getText().equals("")) {
                Main.db.updateDB("INSERT INTO users(username, password) VALUES('" + username.getText() + "', '" + password.getText() + "')");

                Main.userId = Main.db.query("SELECT LAST_INSERT_ID()").getInt("LAST_INSERT_ID()");;
                root = FXMLLoader.load(getClass().getResource("home.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else {
                errorLabel.setText("Passwords don't match or empty field");
            }
        } else {
            errorLabel.setText("Username already taken or empty field");
        }
    }
}