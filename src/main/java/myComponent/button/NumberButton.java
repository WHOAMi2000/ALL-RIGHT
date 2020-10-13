package myComponent.button;

import lombok.Getter;
import lombok.Setter;
import myComponent.MyTextField;
import myComponent.TransLabel;
import utils.*;

@Getter
@Setter
public class NumberButton extends MyButton {
//    陈氢start
    private double stoNumber=0.0;
    public NumberButton(String name){
        super();
        this.setText(name);
    }
    public void generalListener(String name,StringBuilder postfix, MyTextField resultText){
        try{
            this.removeActionListener(this.getActionListeners()[0]);
        }catch(IndexOutOfBoundsException ignored){}
        this.addActionListener(e -> {
            postfix.append(name);
            resultText.setText(postfix.toString());
        });
    }
    public void STOListener(MyTextField resultText){
        this.removeActionListener(this.getActionListeners()[0]);
        this.addActionListener(e -> {
            Postfix exp = new Postfix(resultText.getText());
            String postfix;
            postfix = exp.nifixToPostfix();
            Compute ans = new Compute(postfix);
            stoNumber = ans.compute();

        });
    }

    public void RCLListener(MyTextField resultText,StringBuilder postfix){
        this.removeActionListener(this.getActionListeners()[0]);
        this.addActionListener(e -> {
             postfix.append(stoNumber);
             resultText.setText(postfix.toString());
        });
    }
    public void transformerListener(String name, StringBuilder postfix, MyTextField rawText, MyTextField resultText, TransLabel label){
        this.addActionListener(e -> {
            postfix.append(name);
            rawText.setText(postfix.toString());
            double raw=Double.parseDouble(postfix.toString());
            switch (label.getNo()){
                case 0:{resultText.setText(String.valueOf(raw* Constant.CURRENCY[label.getRow()][label.getCol()]));break;}
                case 1:{resultText.setText(String.valueOf(raw* Constant.LENGTH[label.getRow()][label.getCol()]));break;}
                case 2:{resultText.setText(String.valueOf(raw* Constant.MASS[label.getRow()][label.getCol()]));break;}
                case 3:{resultText.setText(String.valueOf(raw* Constant.AREA[label.getRow()][label.getCol()]));break;}
                case 4:{resultText.setText(String.valueOf(raw* Constant.SPEED[label.getRow()][label.getCol()]));break;}
            }
        });
    }
//    陈氢end
}
