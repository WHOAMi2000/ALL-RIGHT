package tools;

import components.Button.myBtn;
import components.text.NumberInput;

import javax.swing.*;

public class equationSolver extends myBtn {
    public equationSolver(String content){
        super();
        this.setText(content);
    }

    public void generalListener(NumberInput input_a, NumberInput input_b,NumberInput input_c, NumberInput result_1,NumberInput result_2) {
        try {
            this.removeActionListener(this.getActionListeners()[0]);
        } catch (IndexOutOfBoundsException ignored) {
        }
        this.addActionListener(e -> {
            try{
                double a = Double.parseDouble(input_a.getText());
                double b = Double.parseDouble(input_b.getText());
                double c = Double.parseDouble(input_c.getText());
                if(a==0){
                    double x1=-(b/c);
                    String result = String.format("%.2f",x1);
                    result_1.setText("  x = "+result);
                    result_2.setText(null);
                    return;
                }
                double delta = b*b-4*a*c;
                if(delta<0){
                    result_1.setText("no solutions");
                    result_2.setText(null);
                    return;
                }else if(delta==0){
                    double x1=((-b+Math.sqrt(delta))/(2*a));
                    String result = String.format("%.2f",x1);
                    result_1.setText("  x = "+result);
                    result_2.setText(null);
                    return;
                }else{
                    double x1=((-b+Math.sqrt(delta))/(2*a));
                    double x2=((-b-Math.sqrt(delta))/(2*a));
                    String result1 = String.format("%.2f",x1);
                    String result2 = String.format("%.2f",x2);
                    result_1.setText("  x1 = "+result1);
                    result_2.setText("  x2 = "+result2);
                    return;
                }
            }catch (NumberFormatException error){
                result_1.setText("输入系数有误！");
                return;
            }
        });
    }
}
