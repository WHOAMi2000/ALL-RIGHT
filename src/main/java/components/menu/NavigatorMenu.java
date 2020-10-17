package components.menu;

import components.UI.checkBox;

import javax.swing.*;
import java.awt.*;

public class NavigatorMenu extends JComboBox<String> {

    public NavigatorMenu(){
        super();
        this.addItem("计算器");
        this.addItem("单位转换");
        this.addItem("时区转换");
        this.addItem("进制转换");
        this.addItem("方程计算");
        this.addItem("生成随机数");
        this.addItem("数独游戏");
        this.setUI(new checkBox("arrow2.png"));
        this.setFont(new Font("黑体",0,14));
    }

}
