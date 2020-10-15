package components.Button;

import components.text.NumberInput;

import javax.swing.*;

public class randomBtn extends JButton {

    public randomBtn(String content){
        super();
        this.setText(content);
    }

    public void generalListener(numBtn[] numberButtons,clearBtn clearButton,deleteBtn deleteButton,String[] NUMBERKEYS, StringBuilder postfix,NumberInput input) {
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

}
