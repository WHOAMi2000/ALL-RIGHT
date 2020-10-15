package panels;

import components.Button.compoundBtn;
import components.menu.TimeMenu;
import panels.basic.GeneralPanel;
import panels.basic.PicPanel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class TimeZoneTrans {
    private compoundBtn localBtn = new compoundBtn("本地时间");
    private compoundBtn chooseBtn = new compoundBtn("时区");
    JLabel timeZone_1 = new JLabel("timeZone_1",JLabel.CENTER) ;
    JLabel timeZone_2 = new JLabel("timeZone_2",JLabel.CENTER) ;
    JLabel index_label = new JLabel("index",JLabel.CENTER) ;
    private TimeMenu timeMenu = new TimeMenu(index_label,timeZone_1,timeZone_2);


    SimpleDateFormat df = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss 'GMT'");//设置日期格式

    public JPanel init(){
        JPanel showPanel=new GeneralPanel();
        showPanel.setLayout(new GridLayout(5, 1, 3, 3));
        showPanel.add(localBtn);
        showPanel.add(timeZone_1);
        showPanel.add(timeMenu);
        showPanel.add(timeZone_2);
        int hours = Integer.parseInt(timeZone_1.getText().substring(16,18));
        if(hours>=6 && hours<=9){
            JPanel picPanel=new PicPanel(0);
            JPanel generator=new GeneralPanel();
            generator.setLayout(new BorderLayout(3, 5));
            generator.add("North",showPanel);
            generator.add("South",picPanel);
            return generator;
        }else if(hours>9 && hours<16){
            JPanel picPanel=new PicPanel(1);
            JPanel generator=new GeneralPanel();
            generator.setLayout(new BorderLayout(3, 5));
            generator.add("North",showPanel);
            generator.add("South",picPanel);
            return generator;
        }else if(hours>=16 && hours<19){
            JPanel picPanel=new PicPanel(2);
            JPanel generator=new GeneralPanel();
            generator.setLayout(new BorderLayout(3, 5));
            generator.add("North",showPanel);
            generator.add("South",picPanel);
            return generator;
        }else{
            JPanel picPanel=new PicPanel(3);
            JPanel generator=new GeneralPanel();
            generator.setLayout(new BorderLayout(3, 5));
            generator.add("North",showPanel);
            generator.add("South",picPanel);
            return generator;
        }





    }
}
