/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VNDIRECT;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author phung
 */
public class SystemTrayExample {
    public static void main(String[] args) throws AWTException {
        SystemTray tray=SystemTray.getSystemTray();
        Icon icon=UIManager.getIcon("OptionPane.informationIcon");
        Image image=((ImageIcon)icon).getImage();
        
        TrayIcon trayIcon=new TrayIcon(image,"Tray Demo",null);
        trayIcon.addActionListener(new ShowExampleActionListener());
        tray.add(trayIcon);
    }
}
