package myComponent.button;

import javax.swing.*;
import java.awt.*;

public class TransButton extends JButton {
//    陈氢start
    public TransButton(String name){
        super();
        this.setText(name);
        this.setForeground(Color.BLUE);
        this.setBackground(null);
        this.setOpaque(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
//        this.setPreferredSize(new Dimension(70,25));
    }
//    陈氢end
}
