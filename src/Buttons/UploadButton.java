package Buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class UploadButton extends Button implements ActionListener {

    JFileChooser fileChooser = new JFileChooser();
    String imgPath;

    public UploadButton(int x, int y, int width, int height, String text, String position) {
        super(x, y, width, height, text, position);

        addActionListener(this);
    }

    public void putImgInLabel(JLabel label) {
        //Create a label to display the image

        String path= imgPath;
        BufferedImage img = null;
        int width=300,heigth=300;

        try {
            img=ImageIO.read(new File(path));
        } catch(IOException e) {
            e.printStackTrace();
        };

        Image dimg=img.getScaledInstance(width,heigth,Image.SCALE_SMOOTH);
        
        ImageIcon icon = new ImageIcon(dimg);
        label.setIcon(icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle the button click
        if (e.getSource() == this) {
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                // User selected a file
                System.out.println("Selected file: " + fileChooser.getSelectedFile().getName());
                imgPath=fileChooser.getSelectedFile().toString();
            } else {
                // User canceled the file chooser
                System.out.println("File chooser canceled");
            }
        }
    }
}
