package panels.basic;

import javax.swing.*;
import java.awt.*;

public class PicPanel extends JPanel {

    public PicPanel(int index){
        JLabel l=new JLabel();
        Icon icon=new ImageIcon("src/main/resources/"+String.valueOf(index)+".jpeg");     //在此直接创建对象,注意目录之间的分隔符是双斜线
        l.setIcon(icon);
        l.setBounds(10, 10, 100,50);
        this.add(l, Integer.valueOf(Integer.MIN_VALUE));
    }

    public PicPanel(String location){
        JLabel l=new JLabel();
        Icon icon=new ImageIcon(location);     //在此直接创建对象,注意目录之间的分隔符是双斜线

        l.setIcon(icon);
        l.setBounds(10, 10, 100,50);
        this.add(l, Integer.valueOf(Integer.MIN_VALUE));
    }
}
