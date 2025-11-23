package rgr.calculator.command;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractArithmeticCommand implements Command {
    private final JButton actionButton;
    private final JTextField resultField;

    protected AbstractArithmeticCommand(JButton actionButton, JTextField resultField) {
        this.actionButton = actionButton;
        this.resultField = resultField;
    }

    @Override
    public void execute(double a, double b) {
        actionButton.setBackground(Color.YELLOW);
        resultField.setText(calculateResultText(a, b));
    }

    public abstract String calculateResultText(double a, double b);
}

