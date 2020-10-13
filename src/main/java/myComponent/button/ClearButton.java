package myComponent.button;

import myComponent.MyTextField;

public class ClearButton extends MyButton {
//    陈氢start
    public ClearButton(){
        super();
        this.setText("C");
    }
    public void generalListener(StringBuilder postfix, MyTextField resultText){
        this.addActionListener(e -> {
            //注意处理.的情况
            postfix.delete(0,postfix.length());
            resultText.setText("0");
        });
    }
    public void transformerListener(StringBuilder postfix, MyTextField rawText,MyTextField resultText){
        this.addActionListener(e -> {
            //注意处理.的情况
            postfix.delete(0,postfix.length());
            rawText.setText("0");
            resultText.setText("");
        });
    }
//    陈氢end
}
