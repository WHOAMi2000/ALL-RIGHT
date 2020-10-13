package myComponent.comboBox;

import myComponent.decoration.MyComboBoxUI;

import javax.swing.*;

public class NavigatorMenu extends JComboBox<String> {
//    陈氢start
    public NavigatorMenu(){
        super();
        this.addItem("科学计算器");
        this.addItem("程序员计算器");
        this.addItem("转换器");
        this.setOpaque(true);
        this.setUI(new MyComboBoxUI("arrow.png"));
    }
//    陈氢end
}
