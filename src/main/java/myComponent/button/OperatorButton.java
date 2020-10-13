package myComponent.button;
import myComponent.MyTextField;

import java.awt.*;


public class OperatorButton extends MyButton{
//    陈氢start
    public OperatorButton(String name, String operator, StringBuilder postfix, MyTextField resultText, PointButton point)
    {
        super();
       this.setText(name);
       this.setForeground(Color.black);
       this.setBackground(Color.WHITE);
       this.addActionListener(e->{
           try{
               point.setEnabled(true);
           }catch (NullPointerException ignored){
           }
           postfix.append(operator);
           resultText.setText(postfix.toString());
       });
    }
//    陈氢end

}
