package rgr.calculator;

import rgr.calculator.model.Calculator;
import rgr.calculator.controller.CalculatorController;
import rgr.calculator.view.CalculatorView;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        CalculatorController controller = new CalculatorController();
        CalculatorView view = new CalculatorView(controller);

        SwingUtilities.invokeLater(() -> view.setVisible(true));
    }
}