package myComponent;

import javax.swing.JTextField;
import java.awt.*;

public class MyTextField extends JTextField {
//    陈氢start
    public MyTextField(String name,int RorL){
        super();
        this.setText(name);
        // 文本框中的内容采用右对齐方式
        this.setHorizontalAlignment(RorL);
        // 不允许修改结果文本框
        this.setEditable(false);
        this.setFont(new Font("宋体",Font.BOLD,20));
        // 设置文本框背景颜色为透明
        this.setOpaque(true);

    }
//    陈氢end
}
