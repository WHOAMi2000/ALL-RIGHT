package components.Button;

import lombok.Getter;
import lombok.Setter;
import components.text.*;
import common.*;


@Getter
@Setter
public class numBtn extends myBtn {


    public numBtn(String content) {
        super();
        this.setText(content);
    }

    public void generalListener(String name, StringBuilder postfix, NumberInput resultText) {
        try {
            this.removeActionListener(this.getActionListeners()[0]);
        } catch (IndexOutOfBoundsException ignored) {
        }
        this.addActionListener(e -> {
            postfix.append(name);
            resultText.setText(postfix.toString());
        });
    }

    public void transformerListener(String name, StringBuilder postfix, NumberInput rawText, NumberInput resultText, UnitsText label){
        this.addActionListener(e -> {
            postfix.append(name);
            rawText.setText(postfix.toString());
            double raw=Double.parseDouble(postfix.toString());
            switch (label.getNo()){
                case 0:{resultText.setText(String.valueOf(raw* Constant.LENGTH[label.getRow()][label.getCol()]));break;}
                case 1:{resultText.setText(String.valueOf(raw* Constant.MASS[label.getRow()][label.getCol()]));break;}
                case 2:{resultText.setText(String.valueOf(raw* Constant.SPEED[label.getRow()][label.getCol()]));break;}
            }
        });
    }


}