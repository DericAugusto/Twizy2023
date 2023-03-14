import javax.swing.*;
import java.awt.*;

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
        new Bouton(WIDTH/2, HEIGHT/2, 100, 100, "Cliquez").add(this);

        // Définir la disposition de la fenêtre
        setLayout(new BorderLayout());

        // Finaliser la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
