package com.example.twizy3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView imageView;

    public void switchSceneToHelp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("help.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchSceneToAboutUs(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("aboutus.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchSceneToAllSigns(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void choosePicture() throws IOException {
        // Ouvrir la boîte de dialogue de sélection de fichier
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            // Charger l'image sélectionnée dans un objet Image
            Image image = new Image(selectedFile.toURI().toString());
            // Afficher l'image dans un composant ImageView
            imageView.setImage(image);
        }
    }
}