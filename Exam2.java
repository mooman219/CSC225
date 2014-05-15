package exam.pkg2;

/**
 *
 * @author benjaminstaffan
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class Exam2 {

    private JPanel P1, P2;
    private JButton clear,swap,exit;
    private JTextField T1, T2;
    private JLabel L1, L2, L3;
    private ActionListener listener = new ButtonListener();
    
    public Exam2()
    {
        
    }
    
    public static void main(String[] args) {
        JFrame frame = new Exam2();
        frame.setTitle("Exam #2");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public ButtonListener(){
        
    }
}
