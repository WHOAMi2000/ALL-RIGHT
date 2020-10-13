package myComponent.button;

import myComponent.MyTextField;
import myComponent.TransLabel;
import utils.Constant;

public class DeleteButton extends MyButton {
    public DeleteButton(){
        super();
        this.setText("◁");
    }
    //靳辰辰 start
    private boolean twoSymbol(StringBuilder postfix){
        boolean flag = false;
        int len = postfix.length();
        if (len >= 2){
            String str = postfix.substring(len-2,len);
            if (str.equals("ln")){
                flag = true;
            }
        }

        return flag;
    }
    private boolean threeSymbol(StringBuilder postfix){
        boolean flag = false;
        int len = postfix.length();
        if (len >= 3){
            String str = postfix.substring(len-3,len);
            if (str.equals("sin")||str.equals("cos")||str.equals("tan")||
                    str.equals("sec")||str.equals("csc")||str.equals("cot")
                    ||str.equals("log")||str.equals("exp")){
                flag = true;
            }
        }

        return flag;
    }
    private boolean fourSymbol(StringBuilder postfix){
        boolean flag = false;
        int len = postfix.length();
        if (len >= 4){
            String str = postfix.substring(len-4,len);
            if (str.equals("sqrt")||str.equals("cbrt")||str.equals("blog")){
                flag = true;
            }
        }

        return flag;
    }

    private boolean fiveSymbol(StringBuilder postfix){
        boolean flag = false;
        int len = postfix.length();
        if (len >= 5){
            String str = postfix.substring(len-5,len);
            if (str.equals("yroot")){
                flag = true;
            }
        }

        return flag;
    }
    public void generalListener(StringBuilder postfix, MyTextField resultText){
        this.addActionListener(e -> {
            int len = postfix.length();
            if (len == 0){
                resultText.setText("0");
            }
            if (len == 1){
                postfix.delete(len-1,len);
                resultText.setText("0");
            }
            if (len >= 2){
                System.out.println(len);
                if (fiveSymbol(postfix)){
                    postfix.delete(len-5,len);
                    resultText.setText(postfix.toString());
                }
                else if (fourSymbol(postfix)){
                    postfix.delete(len-4,len);
                    resultText.setText(postfix.toString());
                }
                else if (threeSymbol(postfix)){
                    postfix.delete(len-3,len);
                    resultText.setText(postfix.toString());
                }
                else if (twoSymbol(postfix)){
                    postfix.delete(len-2,len);
                    resultText.setText(postfix.toString());
                }
                else {
                    postfix.delete(len-1,len);
                    resultText.setText(postfix.toString());
                }

            }
        });
    }
//    靳辰辰 end
//    陈氢start
    public void transformerListener(StringBuilder postfix, MyTextField rawText,MyTextField resultText, TransLabel label){
        this.addActionListener(e -> {
            int len = postfix.length();
            switch (len){
                case 0:break;
                case 1: postfix.delete(len - 1, len);rawText.setText("0");break;
                default:postfix.delete(len - 1, len);rawText.setText(postfix.toString());break;
            }
            double raw=Double.parseDouble(rawText.getText());
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
