package components;

import javax.swing.*;
import java.awt.*;

public class myText extends JTextField {

    public myText(String content, int m){
        super();

        this.setText(content);
        // 设置文本框背景颜色为透明
        this.setOpaque(false);
        // 文本框中的内容采用右对齐方式
        this.setHorizontalAlignment(m);
        // 不允许修改结果文本框
        this.setEditable(false);
        // 设置文本框的字体
        this.setFont(new Font("ARIAL",Font.BOLD,22));

    }
}
