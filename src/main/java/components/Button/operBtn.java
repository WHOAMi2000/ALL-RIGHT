package components.Button;

import components.myText;

public class operBtn extends myBtn{

    public operBtn(String content, String operator, StringBuilder postfix, myText resultText, pointBtn point) {
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
