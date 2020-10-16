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
    private final String[] NUMBERKEYS = {"0", "1", "2", "3", "4", "5", "6",
            "7", "8", "9"};
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

        clearButton.transformerListener(postfix,rawText,resultText);
        deleteButton.transformerListener(postfix,rawText,resultText,input);

        JPanel showPanel=new GeneralPanel();
        showPanel.setLayout(new GridLayout(5, 1, 3, 3));
        showPanel.add(menu);
        showPanel.add(rawText);
        showPanel.add(navigatorUnitsBoxes[0]);
        showPanel.add(resultText);
        showPanel.add(navigatorUnitsBoxes[1]);

        JPanel buttonPanel1 = new GeneralPanel();
        buttonPanel1.setLayout(new GridLayout(1,4,2,2));
        buttonPanel1.add(numberButtons[0]);buttonPanel1.add(pointButton);buttonPanel1.add(clearButton);buttonPanel1.add(deleteButton);

        JPanel buttonPanel2 = new GeneralPanel();
        // 用网格布局器，3行，3列的网格，网格之间的水平方向间隔为3个象素，垂直方向间隔为3个象素
        buttonPanel2.setLayout(new GridLayout(3, 3, 3, 3));
        buttonPanel2.add(numberButtons[1]);buttonPanel2.add(numberButtons[2]);buttonPanel2.add(numberButtons[3]);
        buttonPanel2.add(numberButtons[4]);buttonPanel2.add(numberButtons[5]);buttonPanel2.add(numberButtons[6]);
        buttonPanel2.add(numberButtons[7]);buttonPanel2.add(numberButtons[8]);buttonPanel2.add(numberButtons[9]);

        JPanel buttonPanel = new GeneralPanel();
        buttonPanel.setLayout(new BorderLayout(3,3));
        buttonPanel.add("Center",buttonPanel1);
        buttonPanel.add("South", buttonPanel2);

        JPanel transformer=new ColorPanel();
        transformer.setLayout(new BorderLayout(4, 25));
        transformer.add("North",showPanel);
        transformer.add("Center",buttonPanel);

        return transformer;
    }
}
