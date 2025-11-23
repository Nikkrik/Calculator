package rgr.calculator.view;

import rgr.calculator.command.*;
import rgr.calculator.controller.CalculatorController;
import rgr.calculator.view.buttons.*;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextField resultField;
    private JButton equalsButton;
    private JButton plusButton;
    private JButton minusButton;
    private JButton multButton;
    private JButton divButton;

    private CalculatorController controller;

    public CalculatorView(CalculatorController controller) {
        this.controller = controller;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Калькулятор MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        firstNumberField = new JTextField();
        secondNumberField = new JTextField();
        resultField = new JTextField();
        resultField.setEnabled(false);

        resultField.setFont(new Font("Arial", Font.BOLD, 18));
        resultField.setHorizontalAlignment(JTextField.CENTER);
        resultField.setBackground(new Color(14, 14, 14));

        equalsButton = new JButton("=");
        plusButton = new JButton("+");
        minusButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");

        // Визуально выделяем выбранную операцию
        updateOperationButtons();

        // Панель для кнопок операций
        JPanel operationPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        operationPanel.add(plusButton);
        operationPanel.add(minusButton);
        operationPanel.add(multButton);
        operationPanel.add(divButton);

        add(new JLabel("Первое число: "));
        add(firstNumberField);
        add(new JLabel("Второе число: "));
        add(secondNumberField);
        add(new JLabel("Операция: "));
        add(operationPanel);
        add(new JLabel("Результат: "));
        add(resultField);
        add(new JLabel()); // Пустая ячейка для выравнивания
        add(equalsButton);

        Command plusCommand = new PlusCommand(plusButton, resultField);
        Command minusCommand = new MinusCommand(minusButton, resultField);
        Command multCommand = new MultCommand(multButton, resultField);
        Command divCommand = new DivCommand(divButton, resultField);

        plusButton.addActionListener(new PlusButton(this, plusCommand));
        minusButton.addActionListener(new MinusButton(this, minusCommand));
        multButton.addActionListener(new MultButton(this, multCommand));
        divButton.addActionListener(new DivButton(this, divCommand));
        equalsButton.addActionListener(new EqualsButton(this));

        setSize(400, 350);
        setLocationRelativeTo(null);
    }

    public void setSelectedOperation(Command command) {
        updateOperationButtons();
        controller.setCommand(command);
    }

    private void updateOperationButtons() {
        // Сбрасываем цвет всех кнопок
        plusButton.setBackground(null);
        minusButton.setBackground(null);
        multButton.setBackground(null);
        divButton.setBackground(null);
    }

    public void calculate() {
        if (controller.isNotSelectedOperation()) {
            JOptionPane.showMessageDialog(this,
                    "Сначала выберите операцию",
                    "Ошибка",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double firstNumber = Double.parseDouble(firstNumberField.getText());
            double secondNumber = Double.parseDouble(secondNumberField.getText());
            controller.calculate(firstNumber, secondNumber);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Пожалуйста, введите корректные числа",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}