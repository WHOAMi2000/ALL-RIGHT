package components.button;
import components.text.*;

public class clearBtn extends myBtn{

    public clearBtn(){
        super();
        this.setText("AC");
    }

    public void generalListener(StringBuilder postfix, NumberInput resultText){
        this.addActionListener(e -> {
                //注意处理.的情况
                postfix.delete(0,postfix.length());
                resultText.setText("0");
        });
    }
    public void transformerListener(StringBuilder postfix, NumberInput rawText, NumberInput resultText){
        this.addActionListener(e -> {
                //注意处理.的情况
            postfix.delete(0,postfix.length());
            rawText.setText("0");
            resultText.setText("");
        });
    }


}
