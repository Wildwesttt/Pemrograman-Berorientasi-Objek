package guiwithjava;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class GuiWithJava {

    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel lblResult;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    GuiWithJava window = new GuiWithJava();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GuiWithJava() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("Kalkulator Sederhana");

        textField1 = new JTextField();
        textField1.setBounds(50, 20, 300, 30);
        frame.getContentPane().add(textField1);
        textField1.setColumns(10);

        textField2 = new JTextField();
        textField2.setBounds(50, 60, 300, 30);
        frame.getContentPane().add(textField2);
        textField2.setColumns(10);

        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 300, 40);
        frame.getContentPane().add(panel);
        panel.setLayout(new GridLayout(1, 5, 5, 0)); // 1 row, 5 columns, 5px horizontal gap, 0px vertical gap

        JButton btnAdd = new JButton("+");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('+');
            }
        });
        panel.add(btnAdd);

        JButton btnSubtract = new JButton("-");
        btnSubtract.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSubtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('-');
            }
        });
        panel.add(btnSubtract);

        JButton btnMultiply = new JButton("*");
        btnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('*');
            }
        });
        panel.add(btnMultiply);

        JButton btnDivide = new JButton("/");
        btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('/');
            }
        });
        panel.add(btnDivide);

        JButton btnMod = new JButton("mod");
        btnMod.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnMod.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('m');
            }
        });
        panel.add(btnMod);

        lblResult = new JLabel("Hasil:");
        lblResult.setHorizontalAlignment(SwingConstants.LEFT);
        lblResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblResult.setBounds(50, 160, 300, 30);
        frame.getContentPane().add(lblResult);
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case 'm':
                    result = num1 % num2;
                    break;
            }
            lblResult.setText("Hasil: " + result);
        } catch (NumberFormatException e) {
            lblResult.setText("Invalid input");
        }
    }
}