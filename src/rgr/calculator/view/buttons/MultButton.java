package rgr.calculator.view.buttons;

import rgr.calculator.command.Command;
import rgr.calculator.view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultButton implements ActionListener {
    private final CalculatorView view;
    private final Command multCommand;

    public MultButton(CalculatorView view, Command multCommand) {
        this.view = view;
        this.multCommand = multCommand;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.setSelectedOperation(multCommand);
    }
}
