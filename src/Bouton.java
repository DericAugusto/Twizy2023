import javax.swing.*;

public class Bouton extends JButton {
    public Bouton(int centerX, int centerY, int width, int height, String text) {
        setText(text);
        setBounds(centerX - width/2, centerY - height/2, width, height);

        // Ajouter un gestionnaire d'événements au bouton
        addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Bonjour !");
        });
    }

    public void add(JFrame window) {
        window.add(this);
    }
}
