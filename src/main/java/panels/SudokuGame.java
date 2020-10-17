package panels;

import components.Button.clearBtn;
import components.Button.compoundBtn;
import components.Button.deleteBtn;
import components.Button.numBtn;
import components.menu.TimeMenu;
import components.text.NumberInput;
import components.text.UnitsText;
import panels.basic.ColorPanel;
import panels.basic.GeneralPanel;
import panels.basic.PicPanel;
import tools.GenerateRandom;
import tools.OpenURL;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class SudokuGame {
    private OpenURL urlLabel = new OpenURL();
    SimpleDateFormat df = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss 'GMT'");//设置日期格式

    public JPanel init(){
        JPanel showPanel=new ColorPanel();
        showPanel.setLayout(new GridLayout(5, 1, 3, 3));
        showPanel.add(urlLabel);
        JPanel picPanel=new PicPanel("src/main/resources/sudoku.jpeg");
        JPanel generator=new GeneralPanel();
        generator.setLayout(new BorderLayout(3, 5));
        generator.add("South",showPanel);
        generator.add("North",picPanel);
        return generator;






    }
}
