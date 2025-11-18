package rgr.calculator.view;

import rgr.calculator.controller.CalculatorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorView extends JFrame {
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;
    private JButton equalsButton;
    private JComboBox<String> operationComboBox;

    private CalculatorController controller;

    public CalculatorView(CalculatorController controller){
        this.controller = controller;
        initializeUI();
    }

    private void initializeUI(){
        setTitle("Калькулятор MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        firstNumberField = new JTextField();
        secondNumberField = new JTextField();
        resultField = new JTextField();
        resultField.setEnabled(false);

        resultField.setFont(new Font("Arial", Font.BOLD, 18));
        resultField.setHorizontalAlignment(JTextField.CENTER);
        resultField.setBackground(new Color(5, 5, 5));

        equalsButton = new JButton("=");

        String[] operations = {"+", "-", "*" , "/"};
        operationComboBox = new JComboBox<>(operations);

        add(new JLabel("Первое число: "));
        add(firstNumberField);

        add(new JLabel("Операция: "));
        add(operationComboBox);

        add(new JLabel("Второе число: "));
        add(secondNumberField);

        add(new JLabel("Результат"));
        add(resultField);

        add(new JLabel());
        add(equalsButton);

        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void calculate(){
        try {
            double firstNumber = Double.parseDouble(firstNumberField.getText());
            double secondNumber = Double.parseDouble(secondNumberField.getText());
            String operation = (String) operationComboBox.getSelectedItem();

            double result = controller.calculate(firstNumber, secondNumber, operation);
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex){
            JOptionPane.showConfirmDialog(this,
                    "Пожалуйста, введите конкретные числа",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
