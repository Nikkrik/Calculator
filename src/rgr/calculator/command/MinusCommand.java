package rgr.calculator.command;

import rgr.calculator.model.Calculator;

public class MinusCommand implements Command {
    private Calculator calculator;

    public MinusCommand(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public double execute(double a, double b){
        return calculator.minus(a, b);
    }
}
