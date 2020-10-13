package myComponent.button;

import myComponent.MyTextField;

import javax.swing.*;
import java.awt.*;

public class RadixButton extends JButton {
//    陈氢start
    public RadixButton(String name,StringBuilder postfix, MyTextField resultText){
        this.setText(name);
        this.setForeground(Color.RED);
        this.setBackground(null);
        this.setOpaque(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
    }
//    陈氢end
}
