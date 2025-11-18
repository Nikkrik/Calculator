package rgr.calculator.command;

import rgr.calculator.model.Calculator;

public class DivCommand implements Command {
    private Calculator calculator;

    public DivCommand(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public double execute(double a, double b){
        return calculator.div(a, b);
    }
}