package Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UploadButton extends Button implements ActionListener {

    JFileChooser fileChooser = new JFileChooser();

    public UploadButton(int x, int y, int width, int height, String text, String position) {
        super(x, y, width, height, text, position);

        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle the button click
        if (e.getSource() == this) {
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
