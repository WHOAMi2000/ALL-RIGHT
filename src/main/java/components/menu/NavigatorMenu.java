package components.menu;

import components.UI.checkBox;

import javax.swing.*;

public class NavigatorMenu extends JComboBox<String> {

    public NavigatorMenu(){
        super();
        this.addItem("计算器");
        this.addItem("单位转换");
        this.addItem("时区转换");
        this.addItem("方程计算");
        this.addItem("生成随机数");
        this.addItem("数独游戏");
        this.addItem("上传背景");
        this.setUI(new checkBox("arrow.png"));
    }

}
