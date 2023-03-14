package Buttons;

import javax.swing.*;

public class PushButton extends Button {
    public PushButton(int x, int y, int width, int height, String text, String position) {
        super(x, y, width, height, text, position);

        addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Bonjour !");
        });
    }

    public void add(JFrame window) {
        window.add(this);
    }
}
