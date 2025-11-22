package rgr.calculator.controller;

import rgr.calculator.model.Calculator;
import rgr.calculator.command.*;

public class CalculatorController {
    private Calculator model;
    private Command currentCommand;

    public CalculatorController(Calculator model) {
        this.model = model;
        this.currentCommand = new PlusCommand(model);
    }
    public void setPlusCommand(){
        this.currentCommand = new PlusCommand(model);
    }
    public void setMinusCommand(){
        this.currentCommand = new MinusCommand(model);
    }
    public void setMultCommand(){
        this.currentCommand = new MultCommand(model);
    }
    public void setDivCommand(){
        this.currentCommand = new DivCommand(model);
    }
    public double calculate(double a, double b){
        if (currentCommand != null){
            return currentCommand.execute(a, b);
        }else {
            System.out.println("Команда не установлена");
            return 0;
        }
    }
}

