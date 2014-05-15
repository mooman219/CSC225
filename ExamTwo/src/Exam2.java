
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class Exam2 extends JFrame {

    private JPanel P1, P2;
    private JButton clear, swap, exit;
    private JTextField T1, T2;
    private JLabel L1, L2, L3;
    private ActionListener listener = new ButtonListener();

    public Exam2() {
        // --- Question 1 ---
        P1 = new JPanel();
        L1 = new JLabel("Name 1");
        L2 = new JLabel("Name 2");
        T1 = new JTextField(15);
        T2 = new JTextField(15);

        P1.setLayout(new GridLayout(2, 2));
        P1.add(L1);
        P1.add(T1);
        P1.add(L2);
        P1.add(T2);
        // ------------------
        // --- Question 2 ---
        P2 = new JPanel();
        clear = new JButton("Clear");
        swap = new JButton("Swap");
        exit = new JButton("Exit");

        P2.setLayout(new GridLayout(1, 3));
        P2.add(clear);
        P2.add(swap);
        P2.add(exit);
        // ------------------
        // --- Question 3 ---
        // a
        swap.addActionListener(listener);
        exit.addActionListener(listener);
        // b

        // ------------------
        this.setLayout(new GridLayout(2, 1));
        this.add(P1);
        this.add(P2);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new Exam2();
        frame.setTitle("Exam #2");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public class ButtonListener implements ActionListener {

        // --- Question 5 ---
        private void swapText() {
            String temp = T1.getText();
            T1.setText(T2.getText());
            T2.setText(temp);
        }
        // ------------------

        // --- Question 6 ---
        private void clearText() {
            T1.setText("");
            T2.setText("");
        }
        // ------------------

        // --- Question 7 ---
        private void exitWindow() {
            System.exit(0);
        }
        // ------------------

    }

}
