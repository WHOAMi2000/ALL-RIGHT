package demo;

import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class postfixExpression {
/*
    public static String exchange(String temp) {

        temp = temp.replace("Mod", "M");
        temp = temp.replace("π", Math.PI + "");
        temp = temp.replace("e", Math.E + "");

        String regex = "[0-9]{1,}!";//匹配诸如3！此类的表达式，并将其转换为f（3）的形式
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(temp);
        Vector<String> matchRegexList = new Vector<String>();
        while (m.find()) {
            matchRegexList.add(m.group());
        }

        for (int i = 0; i < matchRegexList.size(); i++) {
            temp = temp.replace(matchRegexList.get(i), "f(" + matchRegexList.get(i).substring(0, matchRegexList.get(i).length() - 1) + ")");
        }
        return temp;
    }


 */

/*
     public static Vector<String> split(String expression) {
        Vector<String> v = new Vector<>();
        StringBuffer numberString = new StringBuffer();

        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.' || expression.charAt(i) == 'E')//捕获数字
                numberString.append(expression.charAt(i));//由于数字可能由多个字符组成，所以这里先暂存
            else if ((expression.charAt(i) + "").matches("t{0,1}c{0,1}s{0,1}L{0,1}a{0,1}")) {//捕获一些操作符，下同
                v.add(expression.charAt(i) + "");
                i += 2;//捕获后需要将i加上对应的值以便对下一字符扫描，例如abs，扫描到a进此分支，此时i位于a的位置，加2后到s的位置
            } else if ((expression.charAt(i) + "").matches("l{0,1}")) {
                v.add(expression.charAt(i) + "");
                i += 1;
            } else if ((expression.charAt(i) + "").matches("q{0,1}w{0,1}r{0,1}f{0,1}√{0,1}b{0,1}n{0,1}m{0,1}g{0,1}h{0,1}j{0,1}")) {
                v.add(expression.charAt(i) + "");
                i += 0;
            } else {
                if (numberString.length() > 0) {//若有暂存的操作数，则加入Vector
                    v.add(numberString.toString());
                    numberString.setLength(0);
                }

                if (!Character.isSpaceChar(expression.charAt(i))) {//若非空格，则加入
                    v.add(expression.charAt(i) + "");
                }
            }
        }

        if (numberString.length() > 0)//检查是否还有暂存的操作数
            v.add(numberString.toString());

        return v;
    }

 */

    public static double evaluateExpression(Vector<String> tokens) {
        //expression = exchange(expression);
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        //Vector<String> tokens = split(expression);

        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).charAt(0) == '+' || tokens.get(i).charAt(0) == '-') {
                while (!operatorStack.empty() && (operatorStack.peek() + "").matches("\\+{0,1}-{0,1}\\*{0,1}/{0,1}√{0,1}"))
                    processAnOperator(operandStack, operatorStack);

                operatorStack.push(tokens.get(i).charAt(0));
            } else if (tokens.get(i).charAt(0) == '*' || tokens.get(i).charAt(0) == '/' || tokens.get(i).charAt(0) == 'M' || tokens.get(i).charAt(0) == '%') {
                while (!operatorStack.empty() && (operatorStack.peek() + "").matches("\\*{0,1}/{0,1}%{0,1}√{0,1}"))
                    processAnOperator(operandStack, operatorStack);

                operatorStack.push(tokens.get(i).charAt(0));
            } else if (tokens.get(i).charAt(0) == '^') {
                while (!operatorStack.empty() && (operatorStack.peek() == '^'))
                    processAnOperator(operandStack, operatorStack);
                operatorStack.push(tokens.get(i).charAt(0));

            } else if (tokens.get(i).matches("√{0,1}")) {
                operatorStack.push(tokens.get(i).charAt(0));
            } else if (tokens.get(i).charAt(0) == '(')
                operatorStack.push(tokens.get(i).charAt(0));
            else if (tokens.get(i).charAt(0) == ')') {
                while (operatorStack.peek() != '(')
                    processAnOperator(operandStack, operatorStack);

                operatorStack.pop();
            } else {
                operandStack.push(Double.valueOf(tokens.get(i)));
            }
        }

        while (!operatorStack.empty())
            processAnOperator(operandStack, operatorStack);

        return operandStack.pop();

    }

    public static void processAnOperator(Stack<Double> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        double op1 = 0, op2 = 0;
        if (op == '+' || op == '-' || op == '*' || op == '/'  || op == '^' ) {
            op1 = operandStack.pop();
            op2 = operandStack.pop();
        } else if ((op + "").matches("L{0,1}l{0,1}√{0,1}")) {
            op1 = operandStack.pop();
        }

        if (op == '+')
            operandStack.push(op2 + op1);
        else if (op == '-')
            operandStack.push(op2 - op1);
        else if (op == '/')
            operandStack.push(op2 / op1);
        else if (op == '*')
            operandStack.push(op2 * op1);
        else if (op == '^')
            operandStack.push(Math.pow(op2, op1));

        /*ln,log
        else if (op == 'L')
            operandStack.push(Math.log10(op1));
        else if (op == 'l')
            operandStack.push(Math.log(op1));
         */
        else if (op == '√')
            operandStack.push(Math.sqrt(op1));
    }

}

