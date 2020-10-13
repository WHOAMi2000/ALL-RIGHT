package myComponent.button;

import myComponent.WeatherDialog;

import javax.swing.*;
import java.awt.*;

public class WeatherButton extends JButton {
//    陈氢start
    public WeatherButton(){
        this.setIcon(new ImageIcon("src/main/resources/cloud.png"));
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setPreferredSize(new Dimension(30,40));
        this.addActionListener(e -> {
            new WeatherDialog();
        });
    }
//    陈氢end
}
