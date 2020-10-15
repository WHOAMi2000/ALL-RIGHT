package tools;
import components.Button.clearBtn;
import components.Button.deleteBtn;
import components.Button.numBtn;
import components.text.NumberInput;

import javax.swing.*;

public class GenerateRandom extends JButton {
    public GenerateRandom(String content){
        super();
        this.setText(content);
    }

    public void generalListener(NumberInput min,NumberInput max,NumberInput result) {
        try {
            this.removeActionListener(this.getActionListeners()[0]);
        } catch (IndexOutOfBoundsException ignored) {
        }
        this.addActionListener(e -> {
            int min_number = Integer.parseInt(min.getText());
            int max_number = Integer.parseInt(max.getText());
            if(min_number<max_number){
                result.setText("error!");
            }else{
                int ran2 = (int) (Math.random()*(max_number-min_number)+min_number);
                result.setText(String.valueOf(ran2));
            }

        });
    }

}
