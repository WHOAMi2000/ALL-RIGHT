package panels;

import components.Button.*;
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
    private final String[] NUMBERKEYS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private numBtn[] numberButtons=new numBtn[NUMBERKEYS.length];
    private UnitsText input;
    private compoundBtn maxBtn = new compoundBtn("最小值");
    private compoundBtn minBtn = new compoundBtn("最大值");
    private Boolean a = true;
    JLabel lab = new JLabel("结果",JLabel.CENTER) ;   // 实例化标签对象

    public JPanel init(){
        input=new UnitsText();
        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i] = new numBtn(NUMBERKEYS[i]);
        }

        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i].generalListener(NUMBERKEYS[i],postfix_min,input_min);
        }
        clearButton.generalListener(postfix_min,input_min);
        deleteButton.generalListener(postfix_min,input_min);
        generateRandomButton.generalListener(input_min,input_max,result);

        minBtn.randomGeneratorListener(numberButtons,clearButton,deleteButton,NUMBERKEYS,postfix_min,input_min);
        maxBtn.randomGeneratorListener(numberButtons,clearButton,deleteButton,NUMBERKEYS,postfix_max,input_max);

        JPanel showPanel=new GeneralPanel();
        showPanel.setLayout(new GridLayout(5, 1, 3, 3));
        showPanel.add(maxBtn);
        showPanel.add(input_max);
        showPanel.add(minBtn);
        showPanel.add(input_min);
        showPanel.add(lab);
        showPanel.add(result);

        JPanel buttonPanel1 = new GeneralPanel();
        buttonPanel1.setLayout(new GridLayout(1,4,2,2));
        buttonPanel1.add(generateRandomButton);

        JPanel buttonPanel2 = new GeneralPanel();
        // 用网格布局器，3行，3列的网格，网格之间的水平方向间隔为3个象素，垂直方向间隔为3个象素
        buttonPanel2.setLayout(new GridLayout(4, 3, 3, 3));
        buttonPanel2.add(numberButtons[0]);buttonPanel2.add(clearButton);buttonPanel2.add(deleteButton);
        buttonPanel2.add(numberButtons[1]);buttonPanel2.add(numberButtons[2]);buttonPanel2.add(numberButtons[3]);
        buttonPanel2.add(numberButtons[4]);buttonPanel2.add(numberButtons[5]);buttonPanel2.add(numberButtons[6]);
        buttonPanel2.add(numberButtons[7]);buttonPanel2.add(numberButtons[8]);buttonPanel2.add(numberButtons[9]);


        JPanel generator=new ColorPanel();
        generator.setLayout(new BorderLayout(3,3));
        generator.add("North",showPanel);
        generator.add("Center",buttonPanel1);
        generator.add("South", buttonPanel2);


        return generator;
    }
}
