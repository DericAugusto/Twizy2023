import Buttons.PushButton;
import Buttons.UploadButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {

    public App() {
        // Définir le titre et la taille de la fenêtre
        setTitle("Application");

        // Set window size properly
        pack();
        final int WIDTH = 400;
        final int HEIGHT = 400;
        setPreferredSize(new Dimension(WIDTH + getInsets().left + getInsets().right,
                HEIGHT + getInsets().top + getInsets().bottom));
        pack();

        // Créer un bouton et l'ajouter à la fenêtre
        new PushButton(WIDTH/2, HEIGHT/2, 100, 100, "Cliquez", "center").add(this);


        //Créer un deuxiéme bouton
        new UploadButton(0,0,100,100,"Open","").add(this);

        // Définir la disposition de la fenêtre
        setLayout(new BorderLayout());

        // Finaliser la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
