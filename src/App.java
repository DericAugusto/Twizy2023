import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame implements ActionListener{ 

    JFileChooser fileChooser;
    JButton search;

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
<<<<<<< HEAD
        new Bouton(WIDTH/2, HEIGHT/2, 100, 100, "Cliquez").add(this);

        // Définir la disposition de la fenêtre
        setLayout(new BorderLayout());

        // Finaliser la fenetre
=======
        JButton myButton = new JButton("Cliquez ici !");
        myButton.setBounds(200, 0, 150, 150);
        add(myButton);

        // Ajouter un gestionnaire d'événements au bouton
        myButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Bonjour !");
        });

        //Créer un deuxiéme bouton
        search = new JButton("Open");
        search.addActionListener(this);
        search.setBounds(0, 20, 150, 150);
        add(search);
        fileChooser = new JFileChooser();

        // Définir la disposition de la fenêtre
        setLayout(new BorderLayout());

        // Finaliser la fenêtre
        pack();
>>>>>>> 09052f33b07deaf9effef0323063696128650428
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle the button click
        if (e.getSource() == search) {
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // User selected a file
                System.out.println("Selected file: " + fileChooser.getSelectedFile().getName());
            } else {
                // User canceled the file chooser
                System.out.println("File chooser canceled");
            }
        }
    }
}
