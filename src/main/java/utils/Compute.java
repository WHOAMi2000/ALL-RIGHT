package utils;

import com.sun.jdi.event.ExceptionEvent;
import myComponent.MyTextField;

import java.util.Stack;

public class Compute extends Postfix{
    //靳辰辰 start
    private Stack<Double> num = new Stack<>();
    private Stack<Integer> numP = new Stack<>();
    private StringBuilder sb = new StringBuilder();
    private StringBuilder sbP = new StringBuilder();
    char[] c;
    public Compute(String exp){
        this.c = exp.toCharArray();
    }

    public double compute() {

            for (int i = 0; i < c.length; i++) {
                if (isNum(c[i])) {
                    sb.append(c[i]);
                    //如果当前字符已经是表达式字符串最后一位，直接放入操作数栈
                    if (i + 1 == c.length) {
                        num.push(Double.parseDouble(sb.toString()));
                        continue;
                    }
                    //判断是否为多位数，如果当前字符下一位为设置的" "标记,就截取到当前字符
                    if (c[i + 1] == " ".charAt(0)) {
                        num.push(Double.parseDouble(sb.toString()));
                        sb.delete(0, sb.length());
                        continue;
                    }
                    continue;
                }

                //自然对数
                if (c[i] == 'e') {
                    num.push(Math.E);
                }
                //圆周率
                if (c[i] == 'π') {
                    num.push(Math.PI);
                }
                //计算逻辑与
                if (c[i] == '&') {
                    double num1 = num.pop();
                    double num2 = num.pop();
                    double num3 = (int) num1 & (int) num2;
                    num.push(num3);
                }

                //计算逻辑或
                if (c[i] == '|') {
                    double num1 = num.pop();
                    double num2 = num.pop();
                    double num3 = (int) num1 | (int) num2;
                    num.push(num3);
                }

                //计算逻辑亦或
                if (c[i] == '\\') {
                    double num1 = num.pop();
                    double num2 = num.pop();
                    double num3 = (int) num1 ^ (int) num2;
                    num.push(num3);
                }

                //计算逻辑非
                if (c[i] == '~') {
                    double num1 = num.pop();
                    double num2 = ~(int) num1;
                    num.push(num2);
                }

                //计算exp
                if (c[i] == 'x') {
                    double num1 = num.pop();
                    double num2 = num.pop();
                    double num3 = num2 * Math.pow(10, num1);
                    num.push(num3);
                }

                //计算阶乘
//                if (c[i] == '?') {
//                    double num1 = num.pop();
//                    int temp = 1;
//                    double num2 = 1;
//                    while (temp <= num1) {
//                        num2 = num2 * temp;
//                        temp++;
//                    }
//                    if (num2>0)
//                        num.push(num2);
//                }
                //计算加法
                if (c[i] == '+') {
                    double num1 = num.pop();
                    double num2;
                    if (!num.isEmpty())
                        num2 = num.pop();
                    else
                        num2 = 0;
                    num.push(num2 + num1);
                }
                //计算减法
                if (c[i] == '-') {
                    double num1 = num.pop();
                    double num2;
                    if (!num.isEmpty())
                        num2 = num.pop();
                    else
                        num2 = 0;
                    num.push(num2 - num1);
                }
                //计算乘法
                if (c[i] == '*') {
                    num.push(num.pop() * num.pop());
                }
                //计算除法
                if (c[i] == '/') {
                    double num1 = num.pop();
                    double num2 = num.pop();
                    num.push(num2 / num1);
                }
                //取模运算
                if (c[i] == '%') {
                    double num1 = num.pop();
                    double num2 = num.pop();
                    num.push(num2 % num1);
                }
                //计算乘方
                if (c[i] == '^') {
                    double num1 = num.pop();
                    double num2 = num.pop();
                    num.push(Math.pow(num2, num1));
                }
                //计算对数
                if (c[i] == 'l') {
                    double num1 = num.pop();
                    num.push(Math.log(num1));
                }
                //计算正弦
                if (c[i] == 's') {
                    double num1 = num.pop();
                    num.push(Math.sin(num1));
                }
                //计算余弦
                if (c[i] == 'c') {
                    double num1 = num.pop();
                    num.push(Math.cos(num1));
                }
                //计算正切
                if (c[i] == 't') {
                    double num1 = num.pop();
                    num.push(Math.tan(num1));
                }
                //计算sec
                if (c[i] == 'k') {
                    double num1 = num.pop();
                    num.push(1.0 / Math.cos(num1));
                }
                //计算csc
                if (c[i] == 'n') {
                    double num1 = num.pop();
                    num.push(1.0 / Math.sin(num1));
                }
                //计算cot
                if (c[i] == 'p') {
                    double num1 = num.pop();
                    num.push(1.0 / Math.tan(num1));
                }
                //计算二次根式
                if (c[i] == 'q') {
                    double num1 = num.pop();
                    if (num1>=0)
                        num.push(Math.sqrt(num1));
                }
                //计算三次根式
                if (c[i] == 'b') {
                    double num1 = num.pop();
                    if (num1>=0)
                        num.push(Math.cbrt(num1));
                }
                //计算n次根式
                if (c[i] == 'y') {
                    double num1 = num.pop();
                    double num2 = num.pop();
                    if (num2>=0)
                        num.push(Math.pow(num2, 1.0 / num1));
                }
                //计算绝对值
                if (c[i] == 'a') {
                    double num1 = num.pop();
                    num.push(Math.abs(num1));
                }
                //计算log
                if (c[i] == 'g') {
                    double num1 = num.pop();
                    if (num1>=0)
                        num.push(Math.log10(num1));
                }
                //计算log_y(X)
                if (c[i] == 'm') {
                    double num1 = num.pop();
                    double num2 = num.pop();
                    if (num2>=0)
                        num.push(Math.log(num2) / Math.log(num1));
                }
            }
            //扫面完后缀表达式，操作数栈只剩下一个元素，就是计算的结果
            return num.pop();
        }



    public int computeP() {

        for (int i = 0; i < c.length; i++) {
            if (isNum(c[i])) {
                sbP.append(c[i]);
                //如果当前字符已经是表达式字符串最后一位，直接放入操作数栈
                if (i + 1 == c.length) {
                    numP.push(Integer.parseInt(sbP.toString()));
                    continue;
                }
                //判断是否为多位数，如果当前字符下一位为设置的" "标记,就截取到当前字符
                if (c[i + 1] == " ".charAt(0)) {
                    numP.push(Integer.parseInt(sbP.toString()));
                    sbP.delete(0, sbP.length());
                    continue;
                }
                continue;
            }

            //计算逻辑与
            if (c[i] == '&') {
                int num1 = numP.pop();
                int num2 = numP.pop();
                int num3 = num1 & num2;
                numP.push(num3);
            }

            //计算逻辑或
            if (c[i] == '|') {
                int num1 = numP.pop();
                int num2 = numP.pop();
                int num3 = num1 | num2;
                numP.push(num3);
            }

            //计算逻辑亦或
            if (c[i] == '^') {
                int num1 = numP.pop();
                int num2 = numP.pop();
                int num3 = num1 ^ num2;
                numP.push(num3);
            }

            //计算逻辑非
            if (c[i] == '!') {
                int num1 = numP.pop();
                int num2 = ~num1;
                numP.push(num2);
            }

            //计算加法
            if (c[i] == '+') {
                int num1 = numP.pop();
                int num2;
                if (!numP.isEmpty())
                    num2 = numP.pop();
                else
                    num2 = 0;
                numP.push(num2 + num1);
            }
            //计算减法
            if (c[i] == '-') {
                int num1 = numP.pop();
                int num2;
                if (!numP.isEmpty())
                    num2 = numP.pop();
                else
                    num2 = 0;
                numP.push(num2 - num1);
            }
            //计算乘法
            if (c[i] == '*') {
                numP.push(numP.pop() * numP.pop());
            }
            //计算除法
            if (c[i] == '/') {
                int num1 = numP.pop();
                int num2 = numP.pop();
                numP.push(num2 / num1);
            }
            //取模运算
            if (c[i] == '%') {
                int num1 = numP.pop();
                int num2 = numP.pop();
                numP.push(num2 % num1);
            }
//            //计算乘方
//            if (c[i] == '^') {
//                double num1 = num.pop();
//                double num2 = num.pop();
//                num.push(Math.pow(num2, num1));
//            }
//            //计算对数
//            if (c[i] == 'l') {
//                double num1 = num.pop();
//                num.push(Math.log(num1));
//            }
//            //计算正弦
//            if (c[i] == 's') {
//                double num1 = num.pop();
//                num.push(Math.sin(num1));
//            }
//            //计算余弦
//            if (c[i] == 'c') {
//                double num1 = num.pop();
//                num.push(Math.cos(num1));
//            }
//            //计算正切
//            if (c[i] == 't') {
//                double num1 = num.pop();
//                num.push(Math.tan(num1));
//            }
//            //计算sec
//            if (c[i] == 'k') {
//                double num1 = num.pop();
//                num.push(1.0 / Math.cos(num1));
//            }
//            //计算csc
//            if (c[i] == 'n') {
//                double num1 = num.pop();
//                num.push(1.0 / Math.sin(num1));
//            }
//            //计算cot
//            if (c[i] == 'p') {
//                double num1 = num.pop();
//                num.push(1.0 / Math.tan(num1));
//            }
//            //计算二次根式
//            if (c[i] == 'q') {
//                double num1 = num.pop();
//                if (num1>=0)
//                    num.push(Math.sqrt(num1));
//            }
//            //计算三次根式
//            if (c[i] == 'b') {
//                double num1 = num.pop();
//                if (num1>=0)
//                    num.push(Math.cbrt(num1));
//            }
//            //计算n次根式
//            if (c[i] == 'y') {
//                double num1 = num.pop();
//                double num2 = num.pop();
//                if (num2>=0)
//                    num.push(Math.pow(num2, 1.0 / num1));
//            }
//            //计算绝对值
//            if (c[i] == 'a') {
//                double num1 = num.pop();
//                num.push(Math.abs(num1));
//            }
//            //计算log
//            if (c[i] == 'g') {
//                double num1 = num.pop();
//                if (num1>=0)
//                    num.push(Math.log10(num1));
//            }
//            //计算log_y(X)
//            if (c[i] == 'm') {
//                double num1 = num.pop();
//                double num2 = num.pop();
//                if (num2>=0)
//                    num.push(Math.log(num2) / Math.log(num1));
//            }
        }
        //扫面完后缀表达式，操作数栈只剩下一个元素，就是计算的结果
        return numP.pop();
    }
  //靳辰辰 end
}
