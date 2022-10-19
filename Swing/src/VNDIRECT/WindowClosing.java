/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VNDIRECT;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public interface WindowClosing extends WindowListener{
    @Override
        public default void windowActivated(WindowEvent e) {
        }

        @Override
        public default void windowClosed(WindowEvent e) {
        }

        @Override
        public default void windowDeactivated(WindowEvent e) {
        }

        @Override
        public default void windowDeiconified(WindowEvent e) {
        }

        @Override
        public default void windowIconified(WindowEvent e) {
        }

        @Override
        public default void windowOpened(WindowEvent e) {
        }
}
