package panels;

import components.Button.clearBtn;
import components.Button.compoundBtn;
import components.Button.deleteBtn;
import components.Button.numBtn;
import components.text.NumberInput;
import components.text.UnitsText;
import panels.basic.ColorPanel;
import panels.basic.GeneralPanel;
import tools.GenerateRandom;

import javax.swing.*;
import java.awt.*;

public class BasicScaleTransformer {
    private StringBuilder postfix = new StringBuilder();
    private clearBtn clearButton=new clearBtn();
    private deleteBtn deleteButton=new deleteBtn();
    private GenerateRandom generateRandomButton = new GenerateRandom("Generate");
    private final String[] NUMBERKEYS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private numBtn[] numberButtons=new numBtn[NUMBERKEYS.length];

    JLabel binaryLab = new JLabel("二进制",JLabel.CENTER) ;
    JLabel octonaryLab = new JLabel("八进制",JLabel.CENTER) ;
    JLabel hexadecimalLab = new JLabel("十六进制",JLabel.CENTER) ;
    JLabel decimalLab = new JLabel("十进制",JLabel.CENTER) ;
    private NumberInput decimalInput = new NumberInput("0",2);
    private NumberInput binaryResult = new NumberInput("0",2);
    private NumberInput octonaryResult = new NumberInput("0",2);
    private NumberInput hexadecimalResult = new NumberInput("0",2);

    public JPanel init(){
        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i] = new numBtn(NUMBERKEYS[i]);
        }

        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i].ScaleTransListener(NUMBERKEYS[i],postfix,decimalInput,binaryResult,octonaryResult,hexadecimalResult);
        }
        clearButton.generalListener(postfix,decimalInput,binaryResult,octonaryResult,hexadecimalResult);
        deleteButton.generalListener(postfix,decimalInput,binaryResult,octonaryResult,hexadecimalResult);

        JPanel showPanel=new GeneralPanel();
        showPanel.setLayout(new GridLayout(5, 1, 3, 3));
        showPanel.add(decimalLab);
        showPanel.add(decimalInput);
        showPanel.add(binaryLab);
        showPanel.add(binaryResult);
        showPanel.add(octonaryLab);
        showPanel.add(octonaryResult);
        showPanel.add(hexadecimalLab);
        showPanel.add(hexadecimalResult);
        
        JPanel buttonPanel = new GeneralPanel();
        // 用网格布局器，3行，3列的网格，网格之间的水平方向间隔为3个象素，垂直方向间隔为3个象素
        buttonPanel.setLayout(new GridLayout(4, 3, 3, 3));
        buttonPanel.add(numberButtons[0]);buttonPanel.add(clearButton);buttonPanel.add(deleteButton);
        buttonPanel.add(numberButtons[1]);buttonPanel.add(numberButtons[2]);buttonPanel.add(numberButtons[3]);
        buttonPanel.add(numberButtons[4]);buttonPanel.add(numberButtons[5]);buttonPanel.add(numberButtons[6]);
        buttonPanel.add(numberButtons[7]);buttonPanel.add(numberButtons[8]);buttonPanel.add(numberButtons[9]);


        JPanel generator=new ColorPanel();
        generator.setLayout(new BorderLayout(3,3));
        generator.add("North",showPanel);
        generator.add("South", buttonPanel);


        return generator;
    }
}
