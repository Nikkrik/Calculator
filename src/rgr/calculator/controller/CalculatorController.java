package rgr.calculator.controller;

import rgr.calculator.command.*;

public class CalculatorController {

    private Command command;

    public void calculate(double a, double b) {
        command.execute(a, b);
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean isNotSelectedOperation() {
        return command == null;
    }
}