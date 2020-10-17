package components.menu;

import components.text.*;
import common.Constant;

import javax.swing.*;
import java.awt.event.ItemEvent;

public class NavigatorUnitsBox extends JComboBox<String> {

    public NavigatorUnitsBox(){
        super();
        this.setOpaque(true);
    }
    public void formerTextListener(NumberInput rawText, NumberInput resultText, UnitsText label){
        this.addItemListener(e -> {
            if(e.getStateChange()== ItemEvent.SELECTED){
                label.setFormerText("1 "+this.getItemAt(this.getSelectedIndex()));
                label.setRow(this.getSelectedIndex());
                label.updateText();
                double raw=Double.parseDouble(rawText.getText());
                switch (label.getNo()){
                    case 0:{resultText.setText(String.valueOf(raw* Constant.LENGTH[label.getRow()][label.getCol()]));break;}
                    case 1:{resultText.setText(String.valueOf(raw* Constant.MASS[label.getRow()][label.getCol()]));break;}
                    case 2:{resultText.setText(String.valueOf(raw* Constant.SPEED[label.getRow()][label.getCol()]));break;}
                    case 3:{resultText.setText(String.valueOf(raw* Constant.CURRENCY[label.getRow()][label.getCol()]));break;}
                }
            }

        });
    }
    public void latterTextListener(NumberInput rawText, NumberInput resultText, UnitsText label){
        this.addItemListener(e -> {
            if(e.getStateChange()== ItemEvent.SELECTED){
                label.setLatterText(this.getItemAt(this.getSelectedIndex()));
                label.setCol(this.getSelectedIndex());
                label.updateText();
                double raw=Double.parseDouble(rawText.getText());
                switch (label.getNo()){
                    case 0:{resultText.setText(String.valueOf(raw* Constant.LENGTH[label.getRow()][label.getCol()]));break;}
                    case 1:{resultText.setText(String.valueOf(raw* Constant.MASS[label.getRow()][label.getCol()]));break;}
                    case 2:{resultText.setText(String.valueOf(raw* Constant.SPEED[label.getRow()][label.getCol()]));break;}
                    case 3:{resultText.setText(String.valueOf(raw* Constant.CURRENCY[label.getRow()][label.getCol()]));break;}
                }
            }
        });
    }

}
