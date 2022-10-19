import java.awt.*;

public class Page3 extends Frame {
    public static void main(String[] args) {
        Frame screen = new Frame();
        screen = new Page3();
        screen.setSize(500, 100);
        screen.setVisible(true);
        screen.setLayout(new FlowLayout());
        Button pushButton = new Button("press me");
        screen.add(pushButton);
    }
}