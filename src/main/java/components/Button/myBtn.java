package components.Button;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;

public class myBtn extends JButton {

    public myBtn(){
        super();
        // 设置字体
        this.setForeground(Color.black);
        this.setBackground(null);
        this.setFont(new Font("Meiryo UI", 1, 16));
        // 设置按钮背景透明
        this.setOpaque(false);
        // 去焦点框
        this.setFocusPainted(false);
        // 不可填充
        this.setContentAreaFilled(false);
        // 设置边框不可见
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,10));
    }
}

