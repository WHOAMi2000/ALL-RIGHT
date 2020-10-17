package panels;

import panels.basic.GeneralPanel;
import panels.basic.PicPanel;
import tools.OpenURL;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class SudokuGame {
    private OpenURL urlLabel = new OpenURL();
    SimpleDateFormat df = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss 'GMT'");//设置日期格式

    public JPanel init(){
        JPanel showPanel=new GeneralPanel();
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
