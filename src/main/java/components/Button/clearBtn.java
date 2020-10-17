package components.Button;
import components.text.*;

public class clearBtn extends myBtn{

    public clearBtn(){
        super();
        this.setText("AC");
    }

    public void generalListener(StringBuilder postfix, NumberInput resultText_1){
        try {
            this.removeActionListener(this.getActionListeners()[0]);
        } catch (IndexOutOfBoundsException ignored) {
        }
        this.addActionListener(e -> {
            //注意处理.的情况
            postfix.delete(0,postfix.length());
            resultText_1.setText("0");
        });
    }

    public void generalListener(StringBuilder postfix, NumberInput resultText_1, NumberInput resultText_2, NumberInput resultText_3, NumberInput resultText_4){
        try {
            this.removeActionListener(this.getActionListeners()[0]);
        } catch (IndexOutOfBoundsException ignored) {
        }
        this.addActionListener(e -> {
                //注意处理.的情况
                postfix.delete(0,postfix.length());
                resultText_1.setText("0");
                resultText_2.setText("0");
                resultText_3.setText("0");
                resultText_4.setText("0");
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
