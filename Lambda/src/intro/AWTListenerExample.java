/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intro;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author phung
 */
public class AWTListenerExample {

    public static void main(String[] args) {
        Frame screen = new Frame();
        Button button = new Button("Press me");
        screen.add(button);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Welcome to java by example", "Java Sample", JOptionPane.INFORMATION_MESSAGE);
//            }
//        });
        //Page 5
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Info Box: Welcome to Java by Example", "Java Sample", JOptionPane.INFORMATION_MESSAGE);
        });
        screen.setLayout(new FlowLayout());
        screen.setSize(250, 400);
        screen.setVisible(true);
//        screen.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(1);
//            }
//        });
        screen.addWindowListener((WindowClosing) (e) -> System.exit(1));
    }
}
