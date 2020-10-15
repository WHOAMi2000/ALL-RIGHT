package panels;

import components.Button.*;
import components.menu.NavigatorUnitsBox;
import components.menu.TransMenu;
import components.text.NumberInput;
import components.text.UnitsText;
import panels.basic.ColorPanel;
import panels.basic.GeneralPanel;
import tools.GenerateRandom;
import javax.swing.*;
import java.awt.*;

public class RandomGenerator {
    private StringBuilder postfix_min = new StringBuilder();
    private StringBuilder postfix_max = new StringBuilder();
    private NumberInput input_min = new NumberInput("0",2);
    private NumberInput input_max = new NumberInput("0",2);
    private NumberInput result = new NumberInput("0",2);
    private clearBtn clearButton=new clearBtn();
    private deleteBtn deleteButton=new deleteBtn();
    private GenerateRandom generateRandomButton = new GenerateRandom("Generate");
    private final String[] NUMBERKEYS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0","",""};
    private numBtn[] numberButtons=new numBtn[NUMBERKEYS.length];
    private UnitsText input;
    private randomBtn maxBtn = new randomBtn("最小值");
    private randomBtn minBtn = new randomBtn("最大值");
    private Boolean a = true;
    JLabel lab = new JLabel("结果",JLabel.CENTER) ;   // 实例化标签对象

    public JPanel init(){
        input=new UnitsText();
        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i] = new numBtn(NUMBERKEYS[i]);
        }
        numberButtons[10].setEnabled(false);
        numberButtons[11].setEnabled(false);

        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i].generalListener(NUMBERKEYS[i],postfix_min,input_min);
        }
        clearButton.generalListener(postfix_min,input_min);
        deleteButton.generalListener(postfix_min,input_min);
        generateRandomButton.generalListener(input_min,input_max,result);

        minBtn.generalListener(numberButtons,clearButton,deleteButton,NUMBERKEYS,postfix_min,input_min);
        maxBtn.generalListener(numberButtons,clearButton,deleteButton,NUMBERKEYS,postfix_max,input_max);

        JPanel showPanel=new GeneralPanel();
        showPanel.setLayout(new GridLayout(5, 1, 3, 3));
        showPanel.add(maxBtn);
        showPanel.add(input_max);
        showPanel.add(minBtn);
        showPanel.add(input_min);
        showPanel.add(lab);
        showPanel.add(result);

        JPanel padPanel = new ColorPanel();
        padPanel.setLayout(new GridLayout(5, 3, 3, 3));
        padPanel.add(numberButtons[10]);padPanel.add(clearButton);padPanel.add(deleteButton);
        padPanel.add(numberButtons[0]);padPanel.add(numberButtons[1]);padPanel.add(numberButtons[2]);
        padPanel.add(numberButtons[3]);padPanel.add(numberButtons[4]);padPanel.add(numberButtons[5]);
        padPanel.add(numberButtons[6]);padPanel.add(numberButtons[7]);padPanel.add(numberButtons[8]);
        padPanel.add(numberButtons[11]);padPanel.add(numberButtons[9]);padPanel.add(generateRandomButton);

        JPanel transformer=new GeneralPanel();
        transformer.setLayout(new BorderLayout(3, 5));
        transformer.add("North",showPanel);
        transformer.add("South", padPanel);

        return transformer;
    }
}
