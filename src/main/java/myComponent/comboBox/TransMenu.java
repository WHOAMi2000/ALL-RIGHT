package myComponent.comboBox;

import myComponent.TransLabel;
import myComponent.decoration.MyComboBoxUI;

import javax.swing.JComboBox;

public class TransMenu extends JComboBox<String> {
//    陈氢start
    public TransMenu(UnitsComboBox[] unitsComboBoxes, TransLabel label){
        super();
        this.addItem("货币");
        this.addItem("长度");
        this.addItem("质量");
        this.addItem("面积");
        this.addItem("速率");
        this.setOpaque(true);
        this.setUI(new MyComboBoxUI("arrow2.png"));
        this.addActionListener(e -> {
               switch (this.getSelectedIndex()){
                   case 0:{
                       label.setNo(0);
                       label.setRow(0);
                       label.setCol(0);
                       for (UnitsComboBox unitsComboBox:unitsComboBoxes){
//                           unitsComboBox.setSelectedIndex(-1);
                           unitsComboBox.removeAllItems();
                           unitsComboBox.addItem("人民币(CNY)");
                           unitsComboBox.addItem("美元(USD)");
                           unitsComboBox.addItem("英磅(GBP)");
                           unitsComboBox.addItem("欧元(EUR)");
                           unitsComboBox.addItem("韩元(KRW)");
                           unitsComboBox.addItem("日元(JPY)");
                           unitsComboBox.addItem("新台币(TWD)");
                           unitsComboBox.addItem("澳门币(MOP)");
                           unitsComboBox.setSelectedIndex(0);
                       }
                       break;
                   }
                   case 1:{
                       label.setNo(1);
                       label.setRow(0);
                       label.setCol(0);
                       for (UnitsComboBox unitsComboBox:unitsComboBoxes){
                           unitsComboBox.removeAllItems();
                           unitsComboBox.addItem("微米");
                           unitsComboBox.addItem("毫米");
                           unitsComboBox.addItem("厘米");
                           unitsComboBox.addItem("米");
                           unitsComboBox.addItem("公里");
                           unitsComboBox.addItem("英寸");
                           unitsComboBox.addItem("英尺");
                           unitsComboBox.addItem("英里");
                           unitsComboBox.addItem("海里");
                           unitsComboBox.setSelectedIndex(3);
                       }
                       break;
                   }
                   case 2:{
                       label.setNo(2);
                       label.setRow(0);
                       label.setCol(0);
                       for (UnitsComboBox unitsComboBox:unitsComboBoxes){
                           unitsComboBox.removeAllItems();
                           unitsComboBox.addItem("克");
                           unitsComboBox.addItem("斤");
                           unitsComboBox.addItem("千克");
                           unitsComboBox.addItem("公吨");
                           unitsComboBox.addItem("盎司");
                           unitsComboBox.addItem("磅");
                           unitsComboBox.addItem("克拉");
                           unitsComboBox.setSelectedIndex(2);
                       }
                       break;
                   }
                   case 3:{
                       label.setNo(3);
                       label.setRow(0);
                       label.setCol(0);
                       for (UnitsComboBox unitsComboBox:unitsComboBoxes){
                           unitsComboBox.removeAllItems();
                           unitsComboBox.addItem("平方厘米");
                           unitsComboBox.addItem("平方米");
                           unitsComboBox.addItem("公顷");
                           unitsComboBox.addItem("平方公里");
                           unitsComboBox.addItem("平方英寸");
                           unitsComboBox.addItem("平方英尺");
                           unitsComboBox.addItem("市亩");
                           unitsComboBox.setSelectedIndex(1);
                       }
                       break;
                   }
                   case 4:{
                       label.setNo(4);
                       label.setRow(0);
                       label.setCol(0);
                       for (UnitsComboBox unitsComboBox:unitsComboBoxes){
                           unitsComboBox.removeAllItems();
                           unitsComboBox.addItem("米/秒");
                           unitsComboBox.addItem("公里/小时");
                           unitsComboBox.addItem("英里/小时");
                           unitsComboBox.addItem("节");
                           unitsComboBox.setSelectedIndex(1);
                       }
                       break;
                   }
               }
        });
        this.setSelectedIndex(0);
    }
//    陈氢end
}
