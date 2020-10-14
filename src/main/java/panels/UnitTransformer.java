package panels;
import javax.swing.*;
import java.awt.*;
import components.text.*;
import components.Button.*;
import components.menu.*;
import panels.basic.GeneralPanel;
import panels.basic.ColorPanel;

public class UnitTransformer {
    private StringBuilder postfix = new StringBuilder();
    private NumberInput rawText = new NumberInput("0",2);
    private clearBtn clearButton=new clearBtn();
    private deleteBtn deleteButton=new deleteBtn();
    private final String[] NUMBERKEYS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0","",""};
    private numBtn[] numberButtons=new numBtn[NUMBERKEYS.length];
    private pointBtn pointButton=new pointBtn(postfix,rawText);
    private TransMenu menu;
    private NavigatorUnitsBox[] navigatorUnitsBoxes =new NavigatorUnitsBox[2];
    private NumberInput resultText = new NumberInput("",2);
    private UnitsText input;

    public JPanel init(){
        input=new UnitsText();
        navigatorUnitsBoxes[0]=new NavigatorUnitsBox();
        navigatorUnitsBoxes[1]=new NavigatorUnitsBox();
        navigatorUnitsBoxes[0].formerTextListener(rawText,resultText,input);
        navigatorUnitsBoxes[1].latterTextListener(rawText,resultText,input);
        menu=new TransMenu(navigatorUnitsBoxes,input);
        for (int i = 0; i < NUMBERKEYS.length; i++) {
            numberButtons[i] = new numBtn(NUMBERKEYS[i]);
            numberButtons[i].transformerListener(NUMBERKEYS[i],postfix,rawText,resultText,input);
        }
        numberButtons[10].setEnabled(false);
        numberButtons[11].setEnabled(false);
        clearButton.transformerListener(postfix,rawText,resultText);
        deleteButton.transformerListener(postfix,rawText,resultText,input);

        JPanel showPanel=new GeneralPanel();
        showPanel.setLayout(new GridLayout(5, 1, 3, 3));
        showPanel.add(menu);
        showPanel.add(rawText);
        showPanel.add(navigatorUnitsBoxes[0]);
        showPanel.add(resultText);
        showPanel.add(navigatorUnitsBoxes[1]);

        JPanel padPanel = new ColorPanel();
        padPanel.setLayout(new GridLayout(5, 3, 3, 3));
        padPanel.add(numberButtons[10]);padPanel.add(clearButton);padPanel.add(deleteButton);
        padPanel.add(numberButtons[0]);padPanel.add(numberButtons[1]);padPanel.add(numberButtons[2]);
        padPanel.add(numberButtons[3]);padPanel.add(numberButtons[4]);padPanel.add(numberButtons[5]);
        padPanel.add(numberButtons[6]);padPanel.add(numberButtons[7]);padPanel.add(numberButtons[8]);
        padPanel.add(numberButtons[11]);padPanel.add(numberButtons[9]);padPanel.add(pointButton);

        JPanel transformer=new GeneralPanel();
        transformer.setLayout(new BorderLayout(3, 5));
        transformer.add("North",showPanel);
        transformer.add("South", padPanel);

        return transformer;
    }
}
