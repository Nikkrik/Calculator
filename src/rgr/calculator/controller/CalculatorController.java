package rgr.calculator.controller;

import rgr.calculator.model.Calculator;
import rgr.calculator.command.*;

public class CalculatorController {
    private Calculator model;
    private String lastOperation;

    public CalculatorController(Calculator model) {
        this.model = model;
    }

    public double calculate(double a, double b, String operation) {
        this.lastOperation = operation;

        switch (operation) {
            case "+":
                PlusCommand plusCommand = new PlusCommand(model);
                return plusCommand.execute(a, b);
            case "-":
                MinusCommand minusCommand = new MinusCommand(model);
                return minusCommand.execute(a, b);
            case "*":
                MultCommand multCommand = new MultCommand(model);
                return multCommand.execute(a, b);
            case "/":
                DivCommand divCommand = new DivCommand(model);
                return divCommand.execute(a, b);
            default:
                System.out.println("Неизвестная операция: " + operation);
                return 0;
        }
    }

    public String getLastOperation() {
        return lastOperation;
    }
}