package components.button;

import components.text.*;

public class operBtn extends myBtn{

    public operBtn(String content, String operator, StringBuilder postfix, NumberInput resultText, pointBtn point) {
        super();
        this.setText(content);
        this.addActionListener(e->{
            try{
                point.setEnabled(true);
            }catch (NullPointerException ignored){
            }
            postfix.append(operator);
            resultText.setText(postfix.toString());
        });
    }
}
