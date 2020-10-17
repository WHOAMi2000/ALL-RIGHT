package components.Button;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.EmptyStackException;
import tools.postfixExpression;
import tools.scienceCalculate;
import lombok.Getter;
import lombok.Setter;

import components.text.*;

@Getter
@Setter
public class resultBtn extends myBtn {

    public resultBtn(String content){
        super();
        this.setText(content);
    }

    public void scienceListener(String content,StringBuilder expression, NumberInput resultText){
        this.addActionListener(e -> {
            try {
                postfixExpression postfix = new postfixExpression(expression.toString());
                scienceCalculate sciCal = new scienceCalculate(postfix.InifixtoPostfix());
                double ans = sciCal.compute();
                final DecimalFormat df = new DecimalFormat( "#.##########" );
                switch (content){

                    case "=" :
                        resultText.setText(df.format(ans));
                        if (expression.length()!=0)
                            expression.delete(0,expression.length());
                        expression.append(df.format(ans));
                        break;

                    case "1/x" :
                        ans = 1.0/ans; resultText.setText(df.format(ans));
                        expression.delete(0,expression.length());
                        expression.append(df.format(ans));
                        break;

                    case "|x|" :
                        ans = Math.abs(ans);
                        resultText.setText(df.format(ans));
                        expression.delete(0,expression.length());
                        expression.append(df.format(ans));
                        break;

                    case "n!" :
                        long temp = 1, num = 1;
                        while (temp <= ans) {
                            num=num*temp;
                            temp++;
                        }
                        if(ans % 1 == 0) {
                            ans = num;
                            if (ans > 0) {
                                resultText.setText(df.format(ans));
                                expression.delete(0, expression.length());
                                expression.append(df.format(ans));
                            } else resultText.setText("error!");
                        }else resultText.setText("error!");
                        break;

                }
            }

            catch (EmptyStackException ex){
                expression.delete(0,expression.length());
                resultText.setText("error!");
            }
        });

    }

    public static String scientificNotation2String(Double d, int newValue) {
        String value = null;
        NumberFormat nf = NumberFormat.getInstance();
        // 设置此格式中不使用分组
        nf.setGroupingUsed(false);
        // 设置数的小数部分所允许的最大位数。
        nf.setMaximumFractionDigits(newValue);
        value = nf.format(d);
        return value;
    }




}

