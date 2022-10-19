package Unit4;

import java.awt.*;

public class Page2 {
    public static void main(String[] args) {
        Frame screen = new Frame();
        screen.setLayout(null);
        Panel panel = new Panel();
        panel.setBounds(30, 60, 50, 70);
        panel.setBackground(Color.red);
        screen.add(panel);
        screen.setSize(300, 200);
        screen.setVisible(true);
    }
}
