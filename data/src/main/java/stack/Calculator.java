package stack;

import java.util.Stack;

/**
 * @author yangz
 * @date 2022/4/8 - 17:02
 * 实现计算器功能
 */
public class Calculator {
    public static void main(String[] args) {
        /*定义一个逆波兰(后缀)表达式
         * (3+4)*5-6  ==>  3 4 + 5 * 6 -  ==29
         * */
        String str = "3 4 + 5 * 6 -";

        /*将str拆分放入集合中*/
        String[] list = str.split(" ");

        Stack<String> stack = new Stack<>();

        for (String s : list) {
            if (s.matches("\\d+")) { //匹配的是多位数
                //入栈
                stack.push(s);
            } else { //匹配的是符号位,弹出两个数做运算(后一个 +/-/* 前一个)
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int res;

                switch (s) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        res = a / b;
                        break;
                    default:
                        throw new RuntimeException("符号" + s + " 不允许");
                }
                /*将运算结果入栈*/
                stack.push(String.valueOf(res));
            }
        }

        System.out.println("运算结果: " + stack.pop());
    }
}
