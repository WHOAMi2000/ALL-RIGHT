package components.button;
import components.button.*;
import components.myText;
public class clearBtn extends myBtn{

    public clearBtn(){
        super();
        this.setText("AC");
    }

    public void generalListener(StringBuilder postfix, myText resultText){
        this.addActionListener(e -> {
                //注意处理.的情况
                postfix.delete(0,postfix.length());
                resultText.setText("0");
        });
    }
    public void transformerListener(StringBuilder postfix, myText rawText, myText resultText){
        this.addActionListener(e -> {
                //注意处理.的情况
            postfix.delete(0,postfix.length());
            rawText.setText("0");
            resultText.setText("");
        });
    }


}
