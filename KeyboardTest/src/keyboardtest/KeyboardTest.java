/*
 * All rights reserved.
 */
package keyboardtest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cowtop
 */
public class KeyboardTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Robot bleh = new Robot();
            long clink = System.currentTimeMillis();
            double bloop = 0;
            try {
                Thread.sleep(1000l);
            } catch(InterruptedException ex) {
                Logger.getLogger(KeyboardTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            bleh.setAutoDelay(15);
            while(true) {
                bloop = Math.random();
                if(bloop < .20f) {
                    bleh.keyPress(KeyEvent.VK_UP);
                    bleh.keyRelease(KeyEvent.VK_UP);
                } else if(bloop < .60f) {
                    bleh.keyPress(KeyEvent.VK_LEFT);
                    bleh.keyRelease(KeyEvent.VK_LEFT);
                } else if(bloop < .99f) {
                    bleh.keyPress(KeyEvent.VK_RIGHT);
                    bleh.keyRelease(KeyEvent.VK_RIGHT);
                } else {
                    bleh.keyPress(KeyEvent.VK_DOWN);
                        bleh.keyRelease(KeyEvent.VK_DOWN);
                }
                if(System.currentTimeMillis() - clink > 500l) {
                    clink = System.currentTimeMillis();
                    bleh.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    bleh.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                }
            }
        } catch(AWTException ex) {
            Logger.getLogger(KeyboardTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
