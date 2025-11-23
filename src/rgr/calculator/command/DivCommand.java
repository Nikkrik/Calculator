package rgr.calculator.command;

import javax.swing.*;

public class DivCommand extends AbstractArithmeticCommand {
    public static final String ZERO_DIVISION_ERR_TEXT = "Деление на 0";

    public DivCommand(JButton divButton, JTextField resultField){
        super(divButton, resultField);
    }

    @Override
    public String calculateResultText(double a, double b) {
        return b == 0.0 ? ZERO_DIVISION_ERR_TEXT : String.valueOf(a / b);
    }
}