package view.panels;
import myComponent.*;
import myComponent.button.*;
import myComponent.comboBox.*;
import myComponent.panel.GeneralPanel;
import myComponent.panel.HasakiPanel;

import javax.swing.*;
import java.awt.*;

public class Transformer {
//    陈氢start
    private StringBuilder postfix = new StringBuilder();
    private MyTextField rawText = new MyTextField("0",2);
    private ClearButton clearButton=new ClearButton();
    private DeleteButton deleteButton=new DeleteButton();
    private  final String[] NUMBERKEYS = {  "7", "8", "9", "4", "5", "6",
            "1", "2", "3", "0","","" };
    private NumberButton[] numberButtons=new NumberButton[NUMBERKEYS.length];
    private PointButton pointButton=new PointButton(postfix,rawText);
    private TransMenu menu;
    private UnitsComboBox[] unitsComboBoxes=new UnitsComboBox[2];
    private MyTextField resultText = new MyTextField("",2);
    private TransLabel label;

    public JPanel init(){
        label=new TransLabel();
        unitsComboBoxes[0]=new UnitsComboBox();
        unitsComboBoxes[1]=new UnitsComboBox();
        unitsComboBoxes[0].formerTextListener(rawText,resultText,label);
        unitsComboBoxes[1].latterTextListener(rawText,resultText,label);
        menu=new TransMenu(unitsComboBoxes,label);
        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i] = new NumberButton(NUMBERKEYS[i]);
            numberButtons[i].transformerListener(NUMBERKEYS[i],postfix,rawText,resultText,label);
        }
        numberButtons[10].setEnabled(false);
        numberButtons[11].setEnabled(false);
        clearButton.transformerListener(postfix,rawText,resultText);
        deleteButton.transformerListener(postfix,rawText,resultText,label);
        JPanel showPanel=new GeneralPanel();
        showPanel.setLayout(new GridLayout(5, 1, 3, 3));
        showPanel.add(menu);
        showPanel.add(rawText);
        showPanel.add(unitsComboBoxes[0]);
        showPanel.add(resultText);
        showPanel.add(unitsComboBoxes[1]);
//        showPanel.add(label);

        JPanel padPanel = new HasakiPanel();
        // 用网格布局器，4行，4列的网格，网格之间的水平方向间隔为3个象素，垂直方向间隔为3个象素
        padPanel.setLayout(new GridLayout(5, 3, 3, 3));
        padPanel.add(numberButtons[10]);padPanel.add(clearButton);padPanel.add(deleteButton);
        padPanel.add(numberButtons[0]);padPanel.add(numberButtons[1]);padPanel.add(numberButtons[2]);
        padPanel.add(numberButtons[3]);padPanel.add(numberButtons[4]);padPanel.add(numberButtons[5]);
        padPanel.add(numberButtons[6]);padPanel.add(numberButtons[7]);padPanel.add(numberButtons[8]);
        padPanel.add(numberButtons[11]);padPanel.add(numberButtons[9]);padPanel.add(pointButton);

        JPanel transformer=new GeneralPanel();
        transformer.setLayout(new BorderLayout(3, 5));
        transformer.add("North",showPanel);
        transformer.add("Center",label);
        transformer.add("South", padPanel);

        return transformer;
    }
//    陈氢end
}
