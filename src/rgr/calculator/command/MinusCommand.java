package rgr.calculator.command;

import javax.swing.*;

public class MinusCommand extends AbstractArithmeticCommand {

    public MinusCommand(JButton minusButton, JTextField resultField) {
        super(minusButton, resultField);
    }

    @Override
    public String calculateResultText(double a, double b) {
        return String.valueOf(a - b);
    }

}
