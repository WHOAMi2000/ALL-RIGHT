package view.panels;

import myComponent.button.*;
import myComponent.MyTextField;
import myComponent.panel.GeneralPanel;
import myComponent.panel.HasakiPanel;

import javax.swing.*;
import java.awt.*;

public class Science{
//    陈氢start
    private StringBuilder postfix = new StringBuilder();
    private MyTextField resultText = new MyTextField("0",4);

    private ClearButton clearButton;
    private DeleteButton deleteButton;

    private final String[] RESULTKEYS={"1/x","|x|","n!","="};
    private ResultButton[] resultButtons=new ResultButton[RESULTKEYS.length];//1/x,|x|,exp,n!,=
    private final  String[] NUMBERKEYS = { "7", "8", "9", "4", "5", "6","1","2","3","0", "π", "e","-"};
    private NumberButton[] numberButtons=new NumberButton[NUMBERKEYS.length];//0,1,2,3,4,5,6,7,8,9
    private PointButton pointButton;
    private final  String[] TRANSKEYS = { "1st","2nd","3rd"};
    private  TransButton[] transButtons = new TransButton[TRANSKEYS.length];
    private final  String[] OPERATORKEYS = { "x²", "x³", "x^y", "10^x", "log",
            "ln","2√x", "3√x", "y√x", "2^x",
            "log_yx", "e^x","sin", "cos", "tan",
            "sec", "csc", "cot", "exp","(", ")",
            "%", "/", "*", "-", "+"};
    private final  String[] OPERATORS = { "^2", "^3", "^", "10^", "log(", "ln(","sqrt(", "cbrt(", "yroot", "2^", "blog(", "e^","sin(", "cos(", "tan(", "sec(", "csc(", "cot(","exp", "(", ")", "%", "/", "*", "-", "+"};


    private OperatorButton[] operatorButtons=new OperatorButton[OPERATORKEYS.length];
    private RECButton recButton;
    private RCLButton rclButton;
    private EXMButton exmButton;
    private STOButton stoButton;


    public Science(){

    }
    public JPanel init(){

        //      初始化5个结果按钮
        for (int i = 0; i <RESULTKEYS.length; i++) {
            resultButtons[i] = new ResultButton(RESULTKEYS[i]);
            resultButtons[i].scienceListener(RESULTKEYS[i],postfix,resultText);
        }
        //      初始化10个数字按钮
        for (int i = 0; i <NUMBERKEYS.length; i++) {
            numberButtons[i] = new NumberButton(NUMBERKEYS[i]);
            numberButtons[i].generalListener(NUMBERKEYS[i],postfix,resultText);
        }
        pointButton=new PointButton(postfix,resultText);
        //        初始化27个运算符按钮
        for (int i = 0; i <OPERATORKEYS.length; i++) {
            operatorButtons[i] = new OperatorButton(OPERATORKEYS[i],OPERATORS[i],postfix,resultText,pointButton);
        }
        //       初始化3个运算符变换按钮
        for (int i = 0; i < TRANSKEYS.length; i++) {
            transButtons[i] = new TransButton(TRANSKEYS[i]);
        }
        recButton=new RECButton();
        rclButton=new RCLButton();
        exmButton=new EXMButton(numberButtons);
        stoButton =new STOButton();
        clearButton=new ClearButton();
        deleteButton=new DeleteButton();
        clearButton.generalListener(postfix,resultText);
        deleteButton.generalListener(postfix,resultText);
        JPanel memPanel = new GeneralPanel();
        memPanel.setLayout(new GridLayout(1, 4, 3, 3));
        memPanel.add(recButton);
        memPanel.add(exmButton);
        memPanel.add(rclButton);
        memPanel.add(stoButton);

        JPanel padPanel = new GeneralPanel();
        padPanel.setLayout(new GridLayout(7, 4, 3, 3));
        padPanel.add(resultButtons[0]);padPanel.add(resultButtons[1]);padPanel.add(clearButton);padPanel.add(deleteButton);
        padPanel.add(resultButtons[2]);padPanel.add(operatorButtons[18]);padPanel.add(numberButtons[10]);padPanel.add(numberButtons[11]);
        padPanel.add(operatorButtons[19]);padPanel.add(operatorButtons[20]);padPanel.add(operatorButtons[21]);padPanel.add(operatorButtons[22]);
        padPanel.add(numberButtons[0]);padPanel.add(numberButtons[1]);padPanel.add(numberButtons[2]);padPanel.add(operatorButtons[23]);
        padPanel.add(numberButtons[3]);padPanel.add(numberButtons[4]);padPanel.add(numberButtons[5]);padPanel.add(operatorButtons[24]);
        padPanel.add(numberButtons[6]);padPanel.add(numberButtons[7]);padPanel.add(numberButtons[8]);padPanel.add(operatorButtons[25]);
        padPanel.add(numberButtons[12]);padPanel.add(numberButtons[9]);padPanel.add(pointButton);padPanel.add(resultButtons[3]);

        JPanel leftPanel = new GeneralPanel();
        leftPanel.setLayout(new GridLayout(7, 1, 3, 3));
        leftPanel.add(transButtons[0]);
        for(int i=0;i<6;i++){
            leftPanel.add(operatorButtons[i]);
        }

        JPanel buttonPanel=new HasakiPanel();
        buttonPanel.setLayout(new BorderLayout(3, 5));
        buttonPanel.add("North", memPanel);
        buttonPanel.add("Center", padPanel);
        buttonPanel.add("West", leftPanel);

        JPanel science =new GeneralPanel();
        science.setLayout(new BorderLayout(3, 5));
        science.add("South",buttonPanel);
        science.add("Center",resultText);

//        其他监听器

        transButtons[0].addActionListener(e->{
       //     System.out.println(2);
            for (int i = 0; i < 6; i++) {
                leftPanel.remove(i+1);
                leftPanel.add(operatorButtons[i+6],i+1);
            }
            leftPanel.add(transButtons[1],0);
            leftPanel.remove(transButtons[0]);
            leftPanel.revalidate();
        });
        transButtons[1].addActionListener(e->{
            for (int i = 0; i < 6; i++) {
                leftPanel.remove(i+1);
                leftPanel.add(operatorButtons[i+12],i+1);
            }
            leftPanel.add(transButtons[2],0);
            leftPanel.remove(transButtons[1]);
            leftPanel.revalidate();
        });
        transButtons[2].addActionListener(e->{
            for (int i = 0; i < 6; i++) {
                leftPanel.remove(i+1);
                leftPanel.add(operatorButtons[i],i+1);
            }
            leftPanel.add(transButtons[0],0);
            leftPanel.remove(transButtons[2]);
            leftPanel.revalidate();
        });
        stoButton.addActionListener(e -> {
            for(ResultButton resultButton:resultButtons){
                resultButton.setEnabled(false);
            }
            for(OperatorButton operatorButton:operatorButtons){
                operatorButton.setEnabled(false);
            }
            for (TransButton transButton:transButtons){
                transButton.setEnabled(false);
            }
            pointButton.setEnabled(false);
            clearButton.setEnabled(false);
            deleteButton.setEnabled(false);
            rclButton.setEnabled(false);
            for(int i=9;i<13;i++){
                numberButtons[i].setEnabled(false);
            }
            for(int i=0;i<9;i++){
                numberButtons[i].STOListener(resultText);
            }

        });
        recButton.addActionListener(e -> {
            for(ResultButton resultButton:resultButtons){
                resultButton.setEnabled(true);
            }
            for(OperatorButton operatorButton:operatorButtons){
                operatorButton.setEnabled(true);
            }
            for (TransButton transButton:transButtons){
                transButton.setEnabled(true);
            }
            pointButton.setEnabled(true);
            clearButton.setEnabled(true);
            deleteButton.setEnabled(true);
            rclButton.setEnabled(true);
            stoButton.setEnabled(true);
            for(int i=9;i<13;i++){
                numberButtons[i].setEnabled(true);
            }
            for(int i=0;i<9;i++){
                numberButtons[i].generalListener(NUMBERKEYS[i],postfix,resultText);
            }
        });
        rclButton.addActionListener(e -> {
            for(ResultButton resultButton:resultButtons){
                resultButton.setEnabled(false);
            }
            for(OperatorButton operatorButton:operatorButtons){
                operatorButton.setEnabled(false);
            }
            for (TransButton transButton:transButtons){
                transButton.setEnabled(false);
            }
            pointButton.setEnabled(false);
            clearButton.setEnabled(false);
            deleteButton.setEnabled(false);
            stoButton.setEnabled(false);
            for(int i=9;i<13;i++){
                numberButtons[i].setEnabled(false);
            }
            for(int i=0;i<9;i++){
                numberButtons[i].RCLListener(resultText,postfix);
            }
        });
        return science;
    }
//    陈氢end
}
