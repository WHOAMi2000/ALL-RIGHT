package components.menu;

import components.text.UnitsText;

import javax.swing.JComboBox;

public class TransMenu extends JComboBox<String> {

    public TransMenu(NavigatorUnitsBox[] navigatorUnitsBoxes, UnitsText label){
        super();
        this.addItem("长度");
        this.addItem("质量");
        this.addItem("速率");
        this.addItem("货币");
        this.setOpaque(true);
        this.addActionListener(e -> {
               switch (this.getSelectedIndex()){
                   case 0:{
                       label.setNo(0);
                       label.setRow(0);
                       label.setCol(0);
                       for (NavigatorUnitsBox navigatorUnitsBox : navigatorUnitsBoxes){
                           navigatorUnitsBox.removeAllItems();
                           navigatorUnitsBox.addItem("微米");
                           navigatorUnitsBox.addItem("毫米");
                           navigatorUnitsBox.addItem("厘米");
                           navigatorUnitsBox.addItem("米");
                           navigatorUnitsBox.addItem("公里");
                           navigatorUnitsBox.addItem("英寸");
                           navigatorUnitsBox.addItem("英尺");
                           navigatorUnitsBox.addItem("英里");
                           navigatorUnitsBox.addItem("海里");
                           navigatorUnitsBox.setSelectedIndex(3);
                       }
                       break;
                   }
                   case 1:{
                       label.setNo(1);
                       label.setRow(0);
                       label.setCol(0);
                       for (NavigatorUnitsBox navigatorUnitsBox : navigatorUnitsBoxes){
                           navigatorUnitsBox.removeAllItems();
                           navigatorUnitsBox.addItem("克");
                           navigatorUnitsBox.addItem("斤");
                           navigatorUnitsBox.addItem("千克");
                           navigatorUnitsBox.addItem("公吨");
                           navigatorUnitsBox.addItem("盎司");
                           navigatorUnitsBox.addItem("磅");
                           navigatorUnitsBox.addItem("克拉");
                           navigatorUnitsBox.setSelectedIndex(2);
                       }
                       break;
                   }
                   case 2:{
                       label.setNo(2);
                       label.setRow(0);
                       label.setCol(0);
                       for (NavigatorUnitsBox navigatorUnitsBox : navigatorUnitsBoxes){
                           navigatorUnitsBox.removeAllItems();
                           navigatorUnitsBox.addItem("米/秒");
                           navigatorUnitsBox.addItem("公里/小时");
                           navigatorUnitsBox.addItem("英里/小时");
                           navigatorUnitsBox.addItem("节");
                           navigatorUnitsBox.setSelectedIndex(1);
                       }
                       break;
                   }
                   case 3: {
                       label.setNo(3);
                       label.setRow(0);
                       label.setCol(0);
                       for (NavigatorUnitsBox unitsComboBox : navigatorUnitsBoxes) {
                           unitsComboBox.removeAllItems();
                           unitsComboBox.addItem("人民币");
                           unitsComboBox.addItem("美元");
                           unitsComboBox.addItem("英磅");
                           unitsComboBox.addItem("欧元");
                           unitsComboBox.addItem("韩元");
                           unitsComboBox.addItem("日元");
                           unitsComboBox.addItem("新台币");
                           unitsComboBox.addItem("澳门币");
                           unitsComboBox.setSelectedIndex(0);
                       }
                       break;
                   }
               }
        });
        this.setSelectedIndex(0);
    }

}
