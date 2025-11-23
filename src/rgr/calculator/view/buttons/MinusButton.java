package rgr.calculator.view.buttons;

import rgr.calculator.command.Command;
import rgr.calculator.view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinusButton implements ActionListener {
    private final CalculatorView view;
    private final Command minusCommand;

    public MinusButton(CalculatorView view, Command minusCommand) {
        this.view = view;
        this.minusCommand = minusCommand;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.setSelectedOperation(minusCommand);
    }
}

