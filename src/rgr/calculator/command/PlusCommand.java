package rgr.calculator.command;

import javax.swing.*;

public class PlusCommand extends AbstractArithmeticCommand {

    public PlusCommand(JButton plusButton, JTextField resultField) {
        super(plusButton, resultField);
    }

    @Override
    public String calculateResultText(double a, double b) {
        return String.valueOf(a + b);
    }

}
