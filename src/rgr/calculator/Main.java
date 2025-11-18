package rgr.calculator;

import rgr.calculator.model.Calculator;
import rgr.calculator.controller.CalculatorController;
import rgr.calculator.view.CalculatorView;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        Calculator model = new Calculator();
        CalculatorController controller = new CalculatorController(model);
        CalculatorView view = new CalculatorView(controller);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                view.setVisible(true);
            }
        });
    }
}

