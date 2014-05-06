
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Calculator extends JFrame {

    private JButton button_calc;
    private JButton button_clear;
    private JTextField input_equation;
    private JTextField input_value;
    private JLabel lable_equation;
    private JLabel lable_value;
    private JMenuBar menu;
    private JMenu menu_help;
    private JMenuItem menu_help_about;
    private JMenuItem menu_help_info;
    private JMenu menu_op;
    private JMenuItem menu_op_calc;
    private JMenuItem menu_op_clear;
    private JMenuItem menu_op_exit;
    private JPopupMenu.Separator menu_op_seperator;

    public Calculator() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        input_equation = new JTextField();
        input_value = new JTextField();
        lable_equation = new JLabel();
        lable_value = new JLabel();
        button_clear = new JButton();
        button_calc = new JButton();
        menu = new JMenuBar();
        menu_op = new JMenu();
        menu_op_calc = new JMenuItem();
        menu_op_clear = new JMenuItem();
        menu_op_seperator = new JPopupMenu.Separator();
        menu_op_exit = new JMenuItem();
        menu_help = new JMenu();
        menu_help_about = new JMenuItem();
        menu_help_info = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        input_value.setEditable(false);

        lable_equation.setHorizontalAlignment(SwingConstants.RIGHT);
        lable_equation.setText("Enter Equation");

        lable_value.setHorizontalAlignment(SwingConstants.RIGHT);
        lable_value.setText("Value");

        button_clear.setText("Clear");
        button_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearAction(evt);
            }
        });

        button_calc.setText("Calculate");
        button_calc.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calculateAction(evt);
            }
        });

        menu_op.setText("Operations");

        menu_op_calc.setText("Calculate");
        menu_op_calc.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calculateAction(evt);
            }
        });
        menu_op.add(menu_op_calc);

        menu_op_clear.setText("Clear");
        menu_op_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearAction(evt);
            }
        });
        menu_op.add(menu_op_clear);
        menu_op.add(menu_op_seperator);

        menu_op_exit.setText("Exit");
        menu_op_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exit(evt);
            }
        });
        menu_op.add(menu_op_exit);

        menu.add(menu_op);

        menu_help.setText("Help");

        menu_help_about.setText("About");
        menu_help_about.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                displayAbout(evt);
            }
        });
        menu_help.add(menu_help_about);

        menu_help_info.setText("Information");
        menu_help_info.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                displayInfo(evt);
            }
        });
        menu_help.add(menu_help_info);

        menu.add(menu_help);

        setJMenuBar(menu);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(button_calc, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(button_clear, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lable_equation, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(input_equation, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(lable_value, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(input_value, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(input_equation, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lable_equation))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(input_value, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lable_value))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button_clear, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_calc, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void displayInfo(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(this, "Example for input:\n1/2 + 2/3\nNeed space between operands and operation.");
    }

    private void displayAbout(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(this, "Computing Fraction Program");
    }

    private void exit(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void calculateAction(java.awt.event.MouseEvent evt) {
        input_value.setText(Main.calculate(input_equation.getText()));
    }

    private void clearAction(java.awt.event.MouseEvent evt) {
        input_equation.setText("");
        input_value.setText("");
    }
}
