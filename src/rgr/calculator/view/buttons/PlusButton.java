package rgr.calculator.view.buttons;

import rgr.calculator.command.Command;
import rgr.calculator.view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlusButton implements ActionListener {
    private final CalculatorView view;
    private final Command plusCommand;

    public PlusButton(CalculatorView view, Command plusCommand) {
        this.view = view;
        this.plusCommand = plusCommand;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.setSelectedOperation(plusCommand);
    }
}
