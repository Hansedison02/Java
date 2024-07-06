import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private double num1, num2, result;
    private String operator;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        // Create the display panel
        JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        display = new JTextField(16);
        display.setFont(new Font("Raleway Semibold", Font.PLAIN, 20));
        display.setPreferredSize(new Dimension(180, 50));
        display.setEditable(false);
        display.setBackground(new Color(0x23242c));
        display.setForeground(Color.WHITE);
        displayPanel.setBackground(new Color(0x12121b));
        displayPanel.add(display);

        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        buttonPanel.setBackground(new Color(0x12121b));

        // Add the buttons
        String[] buttons = {"+", "-", "*", "/", "1", "2", "3", "C", "4", "5", "6", "=", "7", "8", "9", "."};
        for (String button : buttons) {
            JButton b = new JButton(button);
            b.setBackground(new Color(0x12121b));
            b.setForeground(Color.WHITE);
            b.addActionListener(this);
            buttonPanel.add(b);
        }

        // Add the panels to the main frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(0x12121b));
        getContentPane().add(displayPanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.matches("[0-9.]")) {
            display.setText(display.getText() + command);
        } else {
            switch (command) {
                case "C":
                    display.setText("");
                    num1 = 0;
                    num2 = 0;
                    operator = null;
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    num1 = Double.parseDouble(display.getText());
                    operator = command;
                    display.setText("");
                    break;
                case "=":
                    num2 = Double.parseDouble(display.getText());
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            result = num1 / num2;
                            break;
                    }
                    display.setText(String.format("%.2f", result));
                    num1 = 0;
                    num2 = 0;
                    operator = null;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }
}