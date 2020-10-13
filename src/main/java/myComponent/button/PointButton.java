package myComponent.button;

import myComponent.MyTextField;

public class PointButton extends MyButton {
    public PointButton(StringBuilder postfix, MyTextField resultText){
        super();
        this.setText(".");
        this.addActionListener(e -> {
            //靳辰辰start
//            this.setEnabled(false);
            boolean flag = false,flag2 = false;
            for (int i = postfix.length()-1;i >= 0;i--) {
                if (postfix.charAt(i) == '.') {
                    for (int j = i+1;j < postfix.length();j++){
                        if (!(postfix.charAt(j)>=48 && postfix.charAt(j)<=57))
                        {
                            flag2 = true;
                            break;
                        }
                    }
                    if (!flag2) {
                        flag = true;
                        break;
                    }
                }

            }
            if (!flag) {
                postfix.append(".");
                resultText.setText(postfix.toString());
            }

        });
        //靳辰辰end
    }
}
