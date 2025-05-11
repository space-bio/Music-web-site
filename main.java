import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;
    private JTextField display;
    private JPanel panel;
    private double num1, num2, result;
    private char operator;

    public Main() {
        frame = new JFrame("Calculator");
        display = new JTextField();
        panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 36));
        frame.add(display, BorderLayout.NORTH);

        panel.setLayout(new GridLayout(4, 4, 10, 10));
        frame.add(panel, BorderLayout.CENTER);

        addButton("7");
        addButton("8");
        addButton("9");
        addButton("/");

        addButton("4");
        addButton("5");
        addButton("6");
        addButton("*");

        addButton("1");
        addButton("2");
        addButton("3");
        addButton("-");

        addButton("0");
        addButton(".");
        addButton("=");
        addButton("+");

        frame.setVisible(true);
    }

    private void addButton(String label) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.PLAIN, 36));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(label);
            }
        });
        panel.add(button);
    }

    private void handleButtonClick(String label) {
        if (label.matches("\\d") || label.equals(".")) {
            display.setText(display.getText() + label);
        } else if (label.equals("=")) {
            num2 = Double.parseDouble(display.getText());
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
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
        } else {
            num1 = Double.parseDouble(display.getText());
            operator = label.charAt(0);
            display.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
