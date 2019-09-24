package main.java.Leetcode.medium;

import java.util.Stack;

public class PrefixToPostFixConversion {
    public static void main(String[] args) {
        String input = "*+AB-CD";
        String out = preToPostCovert(input);
        System.out.println(out);
    }

    static String preToPostCovert(String s) {
        if(s == null || s.length() == 0) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        int length = s.length();
        for(int i = length-1; i >= 0; i--) {
            if(isOperator(s.charAt(i))) {
                String temp;
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                temp = operand1 + operand2 + s.charAt(i);
                stack.push(temp);
            } else {
                stack.push(s.charAt(i) + "");
            }
        }
        return stack.peek();
    }

    static boolean isOperator(char op) {
        switch(op) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }
}
