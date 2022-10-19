/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VNDIRECT;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javafx.stage.Screen;

/**
 *
 * @author phung
 */
public class ShowExampleActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        AwtExample1 screen=new AwtExample1();
        screen.setSize(250,400);
        screen.setVisible(true);
        screen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(1);
            }
        });
    }
    public static void main(String[] args) {
//        ShowExampleActionListener screen=new ShowExampleActionListener();
//        screen.setSize(500, 500);
//        screen.setVisible(true);
    }
    
}
