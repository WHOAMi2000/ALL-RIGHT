package view.panels;

import lombok.Data;
import myComponent.comboBox.NavigatorMenu;

import javax.swing.*;
import java.awt.*;
@Data
public class Navigator{
//    陈氢start
    private NavigatorMenu menu=new NavigatorMenu();
    public JPanel init(){
        JPanel navigator=new JPanel();
       navigator.setLayout(new BorderLayout(3, 5));
       navigator.add("North",menu);
       return navigator;
    }
//    陈氢end
}
