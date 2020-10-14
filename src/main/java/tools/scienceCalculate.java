package tools;

import java.util.Stack;

public class scienceCalculate extends postfixExpression{

    private Stack<Double> number = new Stack<>();
    private Stack<Integer> numberP = new Stack<>();
    private StringBuilder strbd = new StringBuilder();
    private StringBuilder strbdP = new StringBuilder();
    char[] Ch;

    public scienceCalculate (String exp){
        this.Ch = exp.toCharArray();
    }

    public double compute() {

        for (int i = 0; i < Ch.length; i++) {
            if (isNum(Ch[i])) {
                strbd.append(Ch[i]);
                //如果当前字符已经是表达式字符串最后一位，直接放入操作数栈
                if (i + 1 == Ch.length) {
                    number.push(Double.parseDouble(strbd.toString()));
                    continue;
                }
                //判断是否为多位数，如果当前字符下一位为设置的" "标记,就截取到当前字符
                if (Ch[i + 1] == " ".charAt(0)) {
                    number.push(Double.parseDouble(strbd.toString()));
                    strbd.delete(0, strbd.length());
                    continue;
                }
                continue;
            }

            //自然对数
            if (Ch[i] == 'e') {
                number.push(Math.E);
            }
            //圆周率
            if (Ch[i] == 'π') {
                number.push(Math.PI);
            }


            //计算exp
            if (Ch[i] == 'x') {
                double num1 = number.pop();
                double num2 = number.pop();
                double num3 = num2 * Math.pow(10, num1);
                number.push(num3);
            }

            //计算加法
            if (Ch[i] == '+') {
                double num1 = number.pop();
                double num2;
                if (!number.isEmpty())
                    num2 = number.pop();
                else
                    num2 = 0;
                number.push(num2 + num1);
            }
            //计算减法
            if (Ch[i] == '-') {
                double num1 = number.pop();
                double num2;
                if (!number.isEmpty())
                    num2 = number.pop();
                else
                    num2 = 0;
                number.push(num2 - num1);
            }

            //计算乘法
            if (Ch[i] == '*') {
                number.push(number.pop() * number.pop());
            }

            //计算除法
            if (Ch[i] == '/') {
                double num1 = number.pop();
                double num2 = number.pop();
                number.push(num2 / num1);
            }

            //取模运算
            if (Ch[i] == '%') {
                double num1 = number.pop();
                double num2 = number.pop();
                number.push(num2 % num1);
            }

            //计算乘方
            if (Ch[i] == '^') {
                double num1 = number.pop();
                double num2 = number.pop();
                number.push(Math.pow(num2, num1));
            }

            //计算对数
            if (Ch[i] == 'l') {
                double num1 = number.pop();
                number.push(Math.log(num1));
            }

            //计算正弦
            if (Ch[i] == 's') {
                double num1 = number.pop();
                number.push(Math.sin(num1));
            }

            //计算余弦
            if (Ch[i] == 'c') {
                double num1 = number.pop();
                number.push(Math.cos(num1));
            }

            //计算正切
            if (Ch[i] == 't') {
                double num1 = number.pop();
                number.push(Math.tan(num1));
            }

            //计算二次根式
            if (Ch[i] == 'q') {
                double num1 = number.pop();
                if (num1>=0)
                    number.push(Math.sqrt(num1));
            }

            //计算绝对值
            if (Ch[i] == 'a') {
                double num1 = number.pop();
                number.push(Math.abs(num1));
            }

            //计算log
            if (Ch[i] == 'g') {
                double num1 = number.pop();
                if (num1>=0)
                    number.push(Math.log10(num1));
            }
        }

        return number.pop();
    }



    public int computeP() {

        for (int i = 0; i < Ch.length; i++) {
            if (isNum(Ch[i])) {
                strbdP.append(Ch[i]);
                //如果当前字符已经是表达式字符串最后一位，直接放入操作数栈
                if (i + 1 == Ch.length) {
                    numberP.push(Integer.parseInt(strbdP.toString()));
                    continue;
                }
                //判断是否为多位数，如果当前字符下一位为设置的" "标记,就截取到当前字符
                if (Ch[i + 1] == " ".charAt(0)) {
                    numberP.push(Integer.parseInt(strbdP.toString()));
                    strbdP.delete(0, strbdP.length());
                    continue;
                }
                continue;
            }


            //计算加法
            if (Ch[i] == '+') {
                int num1 = numberP.pop();
                int num2;
                if (!numberP.isEmpty())
                    num2 = numberP.pop();
                else
                    num2 = 0;
                numberP.push(num2 + num1);
            }

            //计算减法
            if (Ch[i] == '-') {
                int num1 = numberP.pop();
                int num2;
                if (!numberP.isEmpty())
                    num2 = numberP.pop();
                else
                    num2 = 0;
                numberP.push(num2 - num1);
            }

            //计算乘法
            if (Ch[i] == '*') {
                numberP.push(numberP.pop() * numberP.pop());
            }

            //计算除法
            if (Ch[i] == '/') {
                int num1 = numberP.pop();
                int num2 = numberP.pop();
                numberP.push(num2 / num1);
            }

            //取模运算
            if (Ch[i] == '%') {
                int num1 = numberP.pop();
                int num2 = numberP.pop();
                numberP.push(num2 % num1);
            }
        }
        //返回计算结果
        return numberP.pop();
    }

}
