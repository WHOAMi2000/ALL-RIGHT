package tools;

import java.util.Stack;

public class postfixExpression {

    private StringBuilder postfix = new StringBuilder();
    private Stack<Character> postfixStack = new Stack<>();
    private char[] character;

    public postfixExpression(String expression){
        this.character = expression.toCharArray();
    }

    public postfixExpression() {
    }

    //判断数字
    boolean isNum(char c){
        return ( c>=48 && c<=57 )|| c=='.';
    }

    //判断算符优先级
    private int prior(char a){

        int priority_a=0;

        switch (a){

            case '+': priority_a = 0;break;
            case '-': priority_a = 0;break;
            case '*': priority_a = 1;break;
            case '/': priority_a = 1;break;
            case '%': priority_a = 1;break;
            case '^': priority_a = 2;break;    //乘方
            case 'q': priority_a = 2;break;    //开二次根式
            case 'a': priority_a = 2;break;    //绝对值
            case 's': priority_a = 3;break;    //sin
            case 'c': priority_a = 3;break;    //cos
            case 't': priority_a = 3;break;    //tan
            case 'x': priority_a = 3;break;    //exp
            case 'l': priority_a = 3;break;    //ln
            case 'g': priority_a = 3;break;    //log


        }
        return  priority_a;
    }

    public String InifixtoPostfix() {

        //遍历中缀表达式
        for (int i = 0; i< character.length; i++) {
            if (isNum(character[i])){
                postfix.append(character[i]);
                int flag = i;
                //如果当前字符为数字且下一位不数字，或当前数字已是中缀表达式字符串最后一位，在多位数后添加" "来分隔
                if ( (i < character.length-1&&!isNum(character[flag+1]))|| i == character.length-1)
                    postfix.append(" ");
                continue;
            }

            //识别对数log
            if (character[i]=='l'&& character[i+1]=='o'&& character[i+2]=='g'){
                while (!postfixStack.isEmpty()&&(prior(postfixStack.peek())> prior(character[i+2]))){
                    postfix.append(postfixStack.pop());
                }
                postfixStack.push(character[i+2]);
                i+=2;
                continue;
            }

            //识别对数ln
            if (character[i]=='l'&& character[i+1]=='n'){
                while (!postfixStack.isEmpty()&&(prior(postfixStack.peek())> prior(character[i]))){
                    postfix.append(postfixStack.pop());
                }
                postfixStack.push(character[i]);
                i+=1;
                continue;
            }

            //识别绝对值
            if (character[i]=='a'&& character[i+1]=='b'&& character[i+2]=='s'){
                while (!postfixStack.isEmpty()&&(prior(postfixStack.peek())> prior(character[i]))){
                    postfix.append(postfixStack.pop());
                }
                postfixStack.push(character[i]);
                i+=2;
                continue;
            }

            //识别二次根式
            if (character[i]=='s'&& character[i+1]=='q'&& character[i+2]=='r'&& character[i+3]=='t'){
                while (!postfixStack.isEmpty()&&(prior(postfixStack.peek())> prior(character[i+1]))){
                    postfix.append(postfixStack.pop());
                }
                postfixStack.push(character[i+1]);
                i+=3;
                continue;
            }

            //识别指数
            if (character[i]=='^'){
                while (!postfixStack.isEmpty()&&(prior(postfixStack.peek())> prior(character[i]))){
                    postfix.append(postfixStack.pop());
                }
                postfixStack.push(character[i]);
                continue;
            }


            //识别正弦
            if (character[i]=='s'&& character[i+1]=='i'&& character[i+2]=='n'){
                while (!postfixStack.isEmpty()&&(prior(postfixStack.peek())> prior(character[i]))){
                    postfix.append(postfixStack.pop());
                }
                postfixStack.push(character[i]);
                i+=2;
                continue;
            }

            //识别余弦
            if (character[i]=='c'&& character[i+1]=='o'&& character[i+2]=='s'){
                while (!postfixStack.isEmpty()&&(prior(postfixStack.peek())> prior(character[i]))){
                    postfix.append(postfixStack.pop());
                }
                postfixStack.push(character[i]);
                i+=2;
                continue;
            }

            //识别正切
            if (character[i]=='t'&& character[i+1]=='a'&& character[i+2]=='n'){
                while (!postfixStack.isEmpty()&&(prior(postfixStack.peek())> prior(character[i]))){
                    postfix.append(postfixStack.pop());
                }
                postfixStack.push(character[i]);
                i+=2;
                continue;
            }

            //识别左括号直接入操作符栈
            if (character[i]=='('){
                postfixStack.push(character[i]);
                continue;
            }

            //识别乘除
            if (character[i]=='*'|| character[i]=='/'|| character[i]=='%'){
                while (!postfixStack.isEmpty()&&(prior(postfixStack.peek())> prior(character[i]))){
                    postfix.append(postfixStack.pop());
                }
                postfixStack.push(character[i]);
                continue;
            }

            //识别左括号,至遇见右括号,否则将栈中操作符压出添加至后缀串
            if (character[i]==')'){
                while ((!postfixStack.isEmpty())) {
                    if (postfixStack.peek()=='('){
                        postfixStack.pop();
                        break;
                    }
                    postfix.append(postfixStack.pop());
                }
                continue;
            }

            //识别加减
            if (character[i]=='+'|| character[i]=='-'){
                while ((!postfixStack.isEmpty())&& postfixStack.peek()!='('){
                    postfix.append(postfixStack.pop());
                }
                postfixStack.push(character[i]);
                continue;
            }

            //当前字符为自然对数按数字处理
            if (character[i]=='e'){
                postfix.append('e');
                postfix.append(" ");
                continue;
            }

            //当前字符为圆周率按数字处理
            if (character[i]=='π'){
                postfix.append('π');
                postfix.append(" ");
                continue;
            }
        }

        //遍历完弹出，添加到后缀表达式
        while (!postfixStack.isEmpty()){
            postfix.append(postfixStack.pop());
        }

        return postfix.toString();
    }
}

