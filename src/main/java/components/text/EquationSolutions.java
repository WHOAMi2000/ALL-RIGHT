package components.text;

import common.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EquationSolutions extends JLabel {
    private double coefficient_a;
    private double coefficient_b;
    private double coefficient_c;
    private double temp;
    public EquationSolutions(NumberInput a,NumberInput b,NumberInput c){
        super();
        this.setForeground(Color.BLUE);
        this.setPreferredSize(new Dimension(340,30));
        try{
            coefficient_a = Double.parseDouble(a.getText());
            coefficient_b = Double.parseDouble(b.getText());
            coefficient_c = Double.parseDouble(c.getText());
            this.setText("方程"+a.getText()+" x^2 "+b.getText()+" x "+c.getText()+"的解为:");
        }catch (NumberFormatException error){
            this.setText("");
            return;
        }
    }
    public void updateText(NumberInput input,int index){
        try{
            switch (index){
                case 0:coefficient_a = Double.parseDouble(input.getText());
                case 1:coefficient_b = Double.parseDouble(input.getText());
                case 2:coefficient_c = Double.parseDouble(input.getText());
            }
            this.setText("方程"+String.valueOf(coefficient_a)+" x^2 "+String.valueOf(coefficient_b)+" x "+String.valueOf(coefficient_c)+"的解为:");
        }catch (NumberFormatException error){
            this.setText("");
            return;
        }
    }
}
