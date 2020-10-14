package panels;

import javax.swing.*;
import components.myText;
import components.Button.*;

import java.awt.*;

public class Calculator {

    private StringBuilder postfix = new StringBuilder();
    private myText resultText = new myText("0",4);
    private final String[] RESULTBUTTONS={"n!","1/x","|x|","="};
    private final String[] NUMBERBUTTONS = { "7", "8", "9", "4", "5", "6","1","2","3","0", "π", "e"};
    private final  String[] OPERATORBUTTONS = { "%","e^x","2√x", "x²", "x^y", "log", "ln", "sin", "cos", "tan", "(", ")",  "/", "*", "-", "+"};
    private final  String[] OPERATORS = { "%","e^", "sqrt(", "^2", "^",  "log(", "ln(", "sin(", "cos(", "tan(", "(", ")",  "/", "*", "-", "+"};

    private clearBtn clearBtn;
    private deleteBtn deleteBtn;
    private pointBtn pointBtn;
    private resultBtn[] resultBtns = new resultBtn[RESULTBUTTONS.length];//1/x,|x|,exp,n!,=
    private numBtn[] numBtns = new numBtn[NUMBERBUTTONS.length];
    private operBtn[] operBtns = new operBtn[OPERATORBUTTONS.length];

    public JPanel init(){
        //初始化4个结果按钮
        for (int i = 0; i < RESULTBUTTONS.length; i++) {
            resultBtns[i] = new resultBtn(RESULTBUTTONS[i]);
            resultBtns[i].scienceListener(RESULTBUTTONS[i], postfix, resultText);

            //设置等号为蓝色，其他为灰色
            if(i<3)
                resultBtns[i].setBackground(new Color(245, 245, 245));
            else
                resultBtns[i].setBackground(new Color(126, 192, 238));//蓝色
        }
        //初始化12个数字按钮
        for (int i = 0; i < NUMBERBUTTONS.length; i++) {
            numBtns[i] = new numBtn(NUMBERBUTTONS[i]);
            numBtns[i].generalListener(NUMBERBUTTONS[i], postfix, resultText);
            //设置0-9数字按钮字体颜色为白色，其他为灰色
            if (i<10)
                numBtns[i].setBackground(Color.WHITE);
            else
                numBtns[i].setBackground(new Color(245, 245, 245));
        }

        //        初始化16个运算符按钮
        for (int i = 0; i < OPERATORBUTTONS.length; i++) {
            operBtns[i] = new operBtn(OPERATORBUTTONS[i], OPERATORS[i], postfix, resultText, pointBtn);
            // 设置颜色
            operBtns[i].setBackground(new Color(245, 245, 245));
        }

        // 初始化后退、清除按钮
        clearBtn=new clearBtn();
        deleteBtn=new deleteBtn();
        pointBtn=new pointBtn(postfix,resultText);
        // 设置颜色
        clearBtn.setBackground(new Color(255,222,173));
        deleteBtn.setBackground(new Color(255,222,173));
        pointBtn.setBackground(Color.WHITE);

        clearBtn.generalListener(postfix,resultText);
        deleteBtn.generalListener(postfix,resultText);

        JPanel padPanel = new GeneralPanel();
        padPanel.setLayout(new GridLayout(7, 5, 3, 3));
        padPanel.add(operBtns[0]);padPanel.add(resultBtns[0]);padPanel.add(operBtns[1]);padPanel.add(clearBtn);padPanel.add(deleteBtn);
        padPanel.add(resultBtns[1]);padPanel.add(resultBtns[2]);padPanel.add(operBtns[2]);padPanel.add(operBtns[3]);padPanel.add(operBtns[4]);
        padPanel.add(operBtns[5]);padPanel.add(numBtns[10]);padPanel.add(numBtns[11]);padPanel.add(operBtns[10]);padPanel.add(operBtns[11]);
        padPanel.add(operBtns[6]);padPanel.add(numBtns[0]);padPanel.add(numBtns[1]);padPanel.add(numBtns[2]);padPanel.add(operBtns[12]);
        padPanel.add(operBtns[7]);padPanel.add(numBtns[3]);padPanel.add(numBtns[4]);padPanel.add(numBtns[5]);padPanel.add(operBtns[13]);
        padPanel.add(operBtns[8]);padPanel.add(numBtns[6]);padPanel.add(numBtns[7]);padPanel.add(numBtns[8]);padPanel.add(operBtns[14]);
        padPanel.add(operBtns[9]);padPanel.add(pointBtn);padPanel.add(numBtns[9]);padPanel.add(resultBtns[3]);padPanel.add(operBtns[15]);


        JPanel calculator =new JPanel();
        calculator.setLayout(new BorderLayout(3, 5));
        calculator.add("South",padPanel);
        calculator.add("Center",resultText);

        return calculator;
    }

}