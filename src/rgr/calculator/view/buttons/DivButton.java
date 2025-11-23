package rgr.calculator.view.buttons;

import rgr.calculator.command.Command;
import rgr.calculator.view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DivButton implements ActionListener {
    private final CalculatorView view;
    private final Command divCommand;

    public DivButton(CalculatorView view, Command divCommand) {
        this.view = view;
        this.divCommand = divCommand;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.setSelectedOperation(divCommand);
    }
}

