package components.Button;

import components.text.EquationSolutions;
import components.text.NumberInput;

import javax.swing.*;

public class compoundBtn extends JButton {

    public compoundBtn(String content){
        super();
        this.setText(content);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
    }

    public void randomGeneratorListener(numBtn[] numberButtons,clearBtn clearButton,deleteBtn deleteButton,String[] NUMBERKEYS, StringBuilder postfix,NumberInput input) {
        try {
            this.removeActionListener(this.getActionListeners()[0]);
        } catch (IndexOutOfBoundsException ignored) {
        }
        this.addActionListener(e -> {
            for (int i = 0; i < NUMBERKEYS.length; i++) {
                numberButtons[i].generalListener(NUMBERKEYS[i],postfix,input);
            }
            clearButton.generalListener(postfix,input);
            deleteButton.generalListener(postfix,input);
        });
    }

    public void equationSolverListener(int index, numBtn[] numberButtons, clearBtn clearButton, deleteBtn deleteButton, pointBtn pointButton, negativeBtn negativeButton, String[] NUMBERKEYS, StringBuilder postfix, NumberInput input) {
        try {
            this.removeActionListener(this.getActionListeners()[0]);
        } catch (IndexOutOfBoundsException ignored) {
        }
        this.addActionListener(e -> {
            for (int i = 0; i < NUMBERKEYS.length; i++) {
                numberButtons[i].generalListener(NUMBERKEYS[i],postfix,input);
            }
            clearButton.generalListener(postfix,input);
            deleteButton.generalListener(postfix,input);
            pointButton.generalListener(postfix,input);
            negativeButton.generalListener(postfix,input);
        });
    }

}
