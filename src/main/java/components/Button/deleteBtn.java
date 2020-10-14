package components.Button;

import components.myText;

public class deleteBtn extends myBtn {
    public deleteBtn(){
        super();
        this.setText("DEL");
    }

    private boolean symTwo(StringBuilder postfix){
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

    private boolean symThree(StringBuilder postfix){
        boolean flag = false;
        int len = postfix.length();
        if (len >= 3){
            String str = postfix.substring(len-3,len);
            if (str.equals("sin")||str.equals("cos")||str.equals("tan") ||str.equals("log")){
                flag = true;
            }
        }

        return flag;
    }

    private boolean symFour(StringBuilder postfix){
        boolean flag = false;
        int len = postfix.length();
        if (len >= 4){
            String str = postfix.substring(len-4,len);
            if (str.equals("sqrt")){
                flag = true;
            }
        }

        return flag;
    }

    public void generalListener(StringBuilder postfix, myText resultText){
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

                if (symFour(postfix)){
                    postfix.delete(len-4,len);
                    resultText.setText(postfix.toString());
                }
                else if (symThree(postfix)){
                    postfix.delete(len-3,len);
                    resultText.setText(postfix.toString());
                }
                else if (symTwo(postfix)){
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





}

