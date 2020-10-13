package view.panels;

import myComponent.button.MusicButton;
import myComponent.button.WeatherButton;

import javax.swing.*;
import java.awt.*;

public class Widget {
//    陈氢start
    private WeatherButton weatherButton=new WeatherButton();
    private MusicButton work=new MusicButton("src/main/resources/work.mp3","气定神闲");
    private MusicButton eat=new MusicButton("src/main/resources/aihe.mp3","致命节奏");

    public JPanel init(){
         JPanel widget=new JPanel();
         widget.setLayout(new BorderLayout(3, 5));
         widget.add("Center",weatherButton);
         widget.add("West",work);
         widget.add("East",eat);
         return widget;
       }
//       陈氢end
}
