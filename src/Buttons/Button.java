package Buttons;

import javax.swing.*;

public class Button extends JButton {
    public Button(int x, int y, int width, int height, String text, String position) {

        switch (position) {
            case "center":
                setBounds(x - width/2, y - height/2, width, height);
                break;
            default:
                setBounds(x, y, width, height);
        }
        setText(text);
    }

    public void add(JFrame window) {
        window.add(this);
    }


}
