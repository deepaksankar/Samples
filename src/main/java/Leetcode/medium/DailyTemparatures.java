package main.java.Leetcode.medium;

import java.util.Stack;

public class DailyTemparatures {
    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] out = dailyTemperatures(temp);
        System.out.println(out);
    }
    static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        if(T.length == 0) {
            return result;
        }
//        int top = -1;
//        int[] stack = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < T.length; i++) {
            while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i-idx;
            }
            stack.push(i);
        }

        return result;
    }
}
