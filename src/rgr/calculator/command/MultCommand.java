package rgr.calculator.command;

import javax.swing.*;

public class MultCommand extends AbstractArithmeticCommand {

    public MultCommand(JButton multButton, JTextField resultField) {
        super(multButton, resultField);
    }

    @Override
    public String calculateResultText(double a, double b) {
        return String.valueOf(a * b);
    }

}
