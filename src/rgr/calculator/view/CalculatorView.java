package rgr.calculator.view;

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
    private String selectedOperation;

    public CalculatorView(CalculatorController controller) {
        this.controller = controller;
        this.selectedOperation = null;
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

        // Устанавливаем отдельные классы-обработчики для каждой кнопки
        plusButton.addActionListener(new PlusButton(this));
        minusButton.addActionListener(new MinusButton(this));
        multButton.addActionListener(new MultButton(this));
        divButton.addActionListener(new DivButton(this));
        equalsButton.addActionListener(new EqualsButton(this));

        setSize(400, 350);
        setLocationRelativeTo(null);
    }

    // Геттеры для доступа к полям из классов-обработчиков
    public JTextField getFirstNumberField() {
        return firstNumberField;
    }

    public JTextField getSecondNumberField() {
        return secondNumberField;
    }

    public JTextField getResultField() {
        return resultField;
    }

    public CalculatorController getController() {
        return controller;
    }

    public String getSelectedOperation() {
        return selectedOperation;
    }

    public void setSelectedOperation(String operation) {
        this.selectedOperation = operation;
        updateOperationButtons();
    }

    private void updateOperationButtons() {
        // Сбрасываем цвет всех кнопок
        plusButton.setBackground(null);
        minusButton.setBackground(null);
        multButton.setBackground(null);
        divButton.setBackground(null);

        // Подсвечиваем выбранную операцию
        if ("+".equals(selectedOperation)) {
            plusButton.setBackground(Color.YELLOW);
        } else if ("-".equals(selectedOperation)) {
            minusButton.setBackground(Color.YELLOW);
        } else if ("*".equals(selectedOperation)) {
            multButton.setBackground(Color.YELLOW);
        } else if ("/".equals(selectedOperation)) {
            divButton.setBackground(Color.YELLOW);
        }
    }

    public void calculate() {
        if (selectedOperation == null) {
            JOptionPane.showMessageDialog(this,
                    "Сначала выберите операцию",
                    "Ошибка",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double firstNumber = Double.parseDouble(firstNumberField.getText());
            double secondNumber = Double.parseDouble(secondNumberField.getText());

            double result = controller.calculate(firstNumber, secondNumber, selectedOperation);
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Пожалуйста, введите корректные числа",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}