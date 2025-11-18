package rgr.calculator.command;

import rgr.calculator.model.Calculator;

public class MultCommand implements Command {
    private Calculator calculator;

    public MultCommand(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public double execute(double a, double b){
        return calculator.mult(a, b);
    }
}