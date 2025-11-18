package rgr.calculator.command;

import rgr.calculator.model.Calculator;

public class PlusCommand implements Command {
    private Calculator calculator;

    public PlusCommand(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public double execute(double a, double b){
        return calculator.plus(a, b);
    }
}
