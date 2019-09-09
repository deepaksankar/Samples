package main.java.Leetcode.medium;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] input = new String[]{"2", "1", "+", "3", "*"};
        int result = evalRPN(input);
        System.out.println(result);
    }
    static int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                switch(tokens[i]) {
                    case "+":
                        result = a+b;
                        break;
                    case "-":
                        result = a-b;
                        break;
                    case "*":
                        result = a*b;
                        break;
                    case "/":
                        result = a/b;
                        break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
