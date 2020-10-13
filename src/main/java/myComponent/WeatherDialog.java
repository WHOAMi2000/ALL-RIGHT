package myComponent;

import javax.swing.*;
import java.awt.*;

public class WeatherDialog extends JDialog {
//    陈氢start
    public static String dateAndLocation="";
    public static String comf="";
    public static String sport="";
    public static String uv="";
    public WeatherDialog(){
        super();
        this.setTitle("天气指南");
        this.setVisible(true);
        this.setLocation(800, 400);
        this.setSize(300,300);
        this.setIconImage(new ImageIcon("src/main/resources/Q.png").getImage());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        init();
    }
    private void init(){
        JLabel district =new JLabel();
        JTextArea advice=new JTextArea();
        advice.setEditable(false);
        district.setText(dateAndLocation);
        advice.setLineWrap(true);
        advice.append("舒适度指数:\n");
        advice.append(comf+"\n\n");
        advice.append("运动指数:\n");
        advice.append(sport+"\n\n");
        advice.append("防晒指数:\n");
        advice.append(uv);
        getContentPane().setLayout(new BorderLayout(3, 5));
        getContentPane().add("North",district);
        getContentPane().add("Center",advice);
    }
//    陈氢end
}
