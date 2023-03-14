import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public App() {
        // Définir le titre et la taille de la fenêtre
        setTitle("Application");
        setPreferredSize(new Dimension(400, 300));
        setMaximumSize(new Dimension(800, 600));

        // Créer un bouton et l'ajouter à la fenêtre
        JButton myButton = new JButton("Cliquez ici !");
        myButton.setBounds(200, 0, 50, 50);
        add(myButton);

        // Définir la disposition de la fenêtre
        setLayout(new BorderLayout());

        // Ajouter un gestionnaire d'événements au bouton
        myButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Bonjour !");
        });

        // Finaliser la fenêtre
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
