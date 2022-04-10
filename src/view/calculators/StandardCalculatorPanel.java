package view.calculators;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.components.CCDisplay;
import view.components.CCNumPad;

import controller.calculators.CalculatorController;
import model.calculators.StandardCalculatorModelFactory;
import utils.CreateButton;
//TODO MISSING JAVADOC.
/**
 * 
 * MISSING JAVADOC.
 *
 */

public class StandardCalculatorPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -3801351406960094788L;
    private final CCDisplay display = new CCDisplay();
    private final CalculatorController controller;
    //TODO MISSING JAVADOC.
    /**
     * MISSING JAVADOC.
     * @param controller 
     * 
     */
    public StandardCalculatorPanel(final CalculatorController controller) {
        this.controller = controller;
        this.setLayout(new BorderLayout());
        this.add(display, BorderLayout.NORTH);

        this.setNumbers();
        this.setOperators();
    }

    private void setNumbers() {
        final ActionListener btnAl = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.getManager().memory().read(((JButton) e.getSource()).getText());
                display.updateText(controller.getManager().memory().getCurrentState().stream().reduce("", (a, b) -> a + b));
            }
        };
        final ActionListener calcAl = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.getManager().engine().calculate();
                display.updateText(controller.getManager().memory().getCurrentState().stream().reduce("", (a, b) -> a + b));
            }
        };
        final ActionListener backspaceAl = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.getManager().memory().deleteLast();
                display.updateText(controller.getManager().memory().getCurrentState().stream().reduce("", (a, b) -> a + b));

            }
        };
        final JPanel numbers = new CCNumPad(btnAl, calcAl, backspaceAl);
        this.add(numbers, BorderLayout.CENTER);
    }

    private void setOperators() {
        final JPanel operator = new JPanel();
        operator.setLayout(new GridLayout(4, 2));
        for (final var entry : StandardCalculatorModelFactory.create().getBinaryOpMap().entrySet()) {
            operator.add(CreateButton.createOpButton(entry.getKey(), entry.getKey(), entry.getKey(), controller, display));

        }
        for (final var entry : StandardCalculatorModelFactory.create().getUnaryOpMap().entrySet()) {
            //if(entry.getKey().contains("x"))->remove x            esempio : 1/x(0.333)
            /*if (entry.getKey().contains("x")) {
            }*/
            operator.add(CreateButton.createOpButton(entry.getKey(), entry.getKey(), entry.getKey().replaceFirst("x", ""), controller, display));
        }
        this.add(operator, BorderLayout.EAST);
    }
    /**
     * 
     * @return controller
     */

    public CalculatorController getController() {
        return this.controller;
    }
    /**
     * 
     * @return display
     */

    public CCDisplay getDisplay() {
        return this.display;
    }
}
