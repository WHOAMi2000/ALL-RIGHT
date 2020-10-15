package components.Button;

import components.text.NumberInput;

import javax.swing.*;

public class negativeBtn extends myBtn {
    public negativeBtn() {
        super();
        this.setText("-/+");
    }

    public void generalListener(StringBuilder postfix, NumberInput resultText) {
        try {
            this.removeActionListener(this.getActionListeners()[0]);
        } catch (IndexOutOfBoundsException ignored) {
        }
        this.addActionListener(e -> {
            if(postfix.length()==0) return;
            if(postfix.charAt(0)=='-'){
                postfix.deleteCharAt(0);
                resultText.setText(postfix.toString());
            }else{
                postfix.insert(0,'-');
                resultText.setText(postfix.toString());
            }

        });
    }
}
