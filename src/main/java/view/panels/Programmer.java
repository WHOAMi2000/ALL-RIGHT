package view.panels;


import myComponent.button.*;
import myComponent.MyTextField;
import myComponent.panel.GeneralPanel;
import myComponent.panel.HasakiPanel;
import utils.HexBinDecOct;

import javax.swing.*;
import java.awt.*;

public class Programmer{
//    陈氢start
    private StringBuilder postfix = new StringBuilder();
    private MyTextField resultText = new MyTextField("0",4);

    private ClearButton clearButton;
    private DeleteButton deleteButton;
    private final String[] RESULTKEYS={"<<",">>","="};
    private ResultButton[] resultButtons=new ResultButton[3];
    private final  String[] NUMBERKEYS = { "7", "8", "9", "4", "5", "6","1","2","3","0", "A", "B","C","D","E","F","-"};
    private NumberButton[] numberButtons=new NumberButton[NUMBERKEYS.length];
    private final  String[] RADIXKEYS = {"HEX", "DEC", "OCT", "BIN"};
    private  RadixButton[] radixButtons = new RadixButton[RADIXKEYS.length];
    private  final String[] OPERATORKEYS = { "&","|","!","^", "(", ")", "%", "/", "*", "-",  "+", "." };
    private  final String[] OPERATORS = { "&","|","!","^", "(", ")", "%", "/", "*", "-",  "+", "." };
    private  OperatorButton[] operatorButtons = new OperatorButton[OPERATORKEYS.length];
    private HexBinDecOct hexBinDecOct = new HexBinDecOct();
    public Programmer(){

    }


    public JPanel init(){
//      初始化5个结果按钮
        for (int i = 0; i <RESULTKEYS.length; i++) {
            resultButtons[i] = new ResultButton(RESULTKEYS[i]);
        }
        for (int i = 0; i <NUMBERKEYS.length; i++) {
            numberButtons[i] = new NumberButton(NUMBERKEYS[i]);
        }
        //        初始化13个运算符按钮
        for (int i = 0; i <OPERATORKEYS.length; i++) {
            operatorButtons[i] = new OperatorButton(OPERATORKEYS[i],OPERATORS[i],postfix,resultText,null);
        }
        //       初始化4个运算符变换按钮
        for (int i = 0; i < RADIXKEYS.length; i++) {
            radixButtons[i] = new RadixButton(RADIXKEYS[i],postfix,resultText);
        }
        clearButton=new ClearButton();
        deleteButton=new DeleteButton();
        clearButton.generalListener(postfix,resultText);
        deleteButton.generalListener(postfix,resultText);

        JPanel padPanel = new GeneralPanel();
        padPanel.setLayout(new GridLayout(7, 4, 3, 3));
        padPanel.add(resultButtons[0]);padPanel.add(resultButtons[1]);padPanel.add(clearButton);padPanel.add(deleteButton);
        padPanel.add(operatorButtons[0]);padPanel.add(operatorButtons[1]);padPanel.add(operatorButtons[2]);padPanel.add(operatorButtons[3]);
        padPanel.add(operatorButtons[4]);padPanel.add(operatorButtons[5]);padPanel.add(operatorButtons[6]);padPanel.add(operatorButtons[7]);
        padPanel.add(numberButtons[0]);padPanel.add(numberButtons[1]);padPanel.add(numberButtons[2]);padPanel.add(operatorButtons[8]);
        padPanel.add(numberButtons[3]);padPanel.add(numberButtons[4]);padPanel.add(numberButtons[5]);padPanel.add(operatorButtons[9]);
        padPanel.add(numberButtons[6]);padPanel.add(numberButtons[7]);padPanel.add(numberButtons[8]);padPanel.add(operatorButtons[10]);
        padPanel.add(numberButtons[16]);padPanel.add(numberButtons[9]);padPanel.add(operatorButtons[11]);padPanel.add(resultButtons[2]);
        operatorButtons[11].setEnabled(false);

        JPanel leftPanel = new GeneralPanel();
        leftPanel.setLayout(new GridLayout(7, 1, 3, 3));
        leftPanel.add(radixButtons[0]);
        for(int i=10;i<16;i++){
            leftPanel.add(numberButtons[i]);
        }

        JPanel buttonPanel=new HasakiPanel();
        buttonPanel.setLayout(new BorderLayout(3, 5));
        buttonPanel.add("Center", padPanel);
        buttonPanel.add("West",leftPanel);

        JPanel programmer=new GeneralPanel();
        programmer.setLayout(new BorderLayout(3, 5));
        programmer.add("North",resultText);
        programmer.add("South",buttonPanel);


        //特殊监听器
        radixButtons[0].addActionListener(e->{
            for (int i=10;i<16;i++){
                numberButtons[i].setEnabled(false);
            }

            for (int i=0;i<3;i++) {
                resultButtons[i].setSystem(10);
            }
            leftPanel.add(radixButtons[1],0);
            leftPanel.remove(radixButtons[0]);
            leftPanel.revalidate();
            StringBuilder temp = new StringBuilder();
            temp.append(postfix);
            postfix.delete(0,postfix.length());
//            postfix.append(temp);
            postfix.append(hexBinDecOct.Convertion(10,16,temp));
            resultText.setText(postfix.toString());
//            for (int i=0;i<3;i++) {
//                resultButtons[i].setSystem(10);
//            }
        });
        radixButtons[1].addActionListener(e->{

            for (int i=0;i<3;i++) {
                resultButtons[i].setSystem(8);
            }
            numberButtons[1].setEnabled(false);
            numberButtons[2].setEnabled(false);
            leftPanel.add(radixButtons[2],0);
            leftPanel.remove(radixButtons[1]);
            leftPanel.revalidate();
            StringBuilder temp = new StringBuilder();
            temp.append(postfix);
            postfix.delete(0,postfix.length());
//            postfix.append(temp);
            postfix.append( hexBinDecOct.Convertion(8,10,temp));
            resultText.setText(postfix.toString());
//            for (int i=0;i<3;i++) {
//                resultButtons[i].setSystem(8);
//            }
        });
        radixButtons[2].addActionListener(e->{
            for (int i=0;i<3;i++) {
                resultButtons[i].setSystem(2);
            }

            numberButtons[0].setEnabled(false);
            numberButtons[3].setEnabled(false);
            numberButtons[4].setEnabled(false);
            numberButtons[5].setEnabled(false);
            numberButtons[7].setEnabled(false);
            numberButtons[8].setEnabled(false);
            leftPanel.add(radixButtons[3],0);
            leftPanel.remove(radixButtons[2]);
            leftPanel.revalidate();
            StringBuilder temp = new StringBuilder();
            temp.append(postfix);
            postfix.delete(0,postfix.length());
//            postfix.append(resultText.getText());
            postfix.append(hexBinDecOct.Convertion(2,8,temp));
            resultText.setText(postfix.toString());

//            for (int i=0;i<3;i++) {
//                resultButtons[i].setSystem(2);
//            }
        });
        radixButtons[3].addActionListener(e->{
            for (int i=0;i<16;i++){
                numberButtons[i].setEnabled(true);
            }

            for (int i=0;i<3;i++) {
                resultButtons[i].setSystem(16);
            }

            leftPanel.add(radixButtons[0],0);
            leftPanel.remove(radixButtons[3]);
            leftPanel.revalidate();
            StringBuilder temp = new StringBuilder();
            temp.append(postfix);
            postfix.delete(0,postfix.length());
//            postfix.append(resultText.getText());
            postfix.append(hexBinDecOct.Convertion(16,2,temp));
            resultText.setText(postfix.toString());

//            for (int i=0;i<3;i++) {
//                resultButtons[i].setSystem(16);
//            }
        });


        for (int i = 0; i <RESULTKEYS.length; i++) {
            resultButtons[i].programmerListener(RESULTKEYS[i],postfix,resultText);
//            System.out.println(systemRecognization());
            //RESULTKEYS[i],postfix,resultText
            //      初始化16个数字按钮
        }

        for (int i = 0; i <NUMBERKEYS.length; i++) {
          //  numberButtons[i] = new NumberButton(NUMBERKEYS[i]);
            numberButtons[i].generalListener(NUMBERKEYS[i],postfix,resultText);
        }
        return programmer;
    }
//    陈氢end
}
