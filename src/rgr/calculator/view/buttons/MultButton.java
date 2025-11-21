package rgr.calculator.view.buttons;

import rgr.calculator.view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultButton implements ActionListener {
    private CalculatorView view;

    public MultButton(CalculatorView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        view.setSelectedOperation("*");
    }
}

