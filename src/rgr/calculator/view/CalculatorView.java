package rgr.calculator.view;

import rgr.calculator.controller.CalculatorController;
import rgr.calculator.view.buttons.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

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
    private Map<String, JButton> operationButtons;
    private Map<String, Runnable> commandSetters;

    public CalculatorView(CalculatorController controller) {
        this.controller = controller;
        initializeMaps();
        initializeUI();
    }

    private void initializeMaps() {
        operationButtons = new HashMap<>();
        commandSetters = new HashMap<>();

        commandSetters.put("+", () -> controller.setPlusCommand());
        commandSetters.put("-", () -> controller.setMinusCommand());
        commandSetters.put("*", () -> controller.setMultCommand());
        commandSetters.put("/", () -> controller.setDivCommand());
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
        resultField.setBackground(new Color(17, 17, 17));

        equalsButton = new JButton("=");
        plusButton = new JButton("+");
        minusButton = new JButton("-");
        multButton = new JButton("*");
        divButton = new JButton("/");

        // Заполняем карту кнопок операций
        operationButtons.put("+", plusButton);
        operationButtons.put("-", minusButton);
        operationButtons.put("*", multButton);
        operationButtons.put("/", divButton);

        // Используем ТОЛЬКО классы кнопок (убраны лямбда-выражения)
        plusButton.addActionListener(new PlusButton(this));
        minusButton.addActionListener(new MinusButton(this));
        multButton.addActionListener(new MultButton(this));
        divButton.addActionListener(new DivButton(this));
        equalsButton.addActionListener(new EqualsButton(this));

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

        setSize(400, 350);
        setLocationRelativeTo(null);
    }

    public void setSelectedOperation(String operation) {
        // Сбрасываем подсветку всех кнопок операций
        for (JButton button : operationButtons.values()) {
            button.setBackground(null);
        }

        // Подсвечиваем выбранную кнопку и устанавливаем команду
        JButton selectedButton = operationButtons.get(operation);
        if (selectedButton != null) {
            selectedButton.setBackground(Color.YELLOW);

            Runnable commandSetter = commandSetters.get(operation);
            if (commandSetter != null) {
                commandSetter.run();
            }
        }
    }

    public void calculate() {
        try {
            double firstNumber = Double.parseDouble(firstNumberField.getText());
            double secondNumber = Double.parseDouble(secondNumberField.getText());

            double result = controller.calculate(firstNumber, secondNumber);
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Пожалуйста, введите корректные числа",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Ошибка вычисления",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
