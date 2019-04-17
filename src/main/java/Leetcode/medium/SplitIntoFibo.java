package main.java.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing numbers, identify the split for the list of numbers that can be added to the output list
 * if the numbers are a Fibo series
 */
public class SplitIntoFibo {
    public static void main(String[] args) {
        List<Integer> out = splitIntoFibonacci("123456579");
        System.out.println(out);
    }

    static List<Integer> splitIntoFibonacci(String S) {
        List<Integer> out = new ArrayList<>();

        if(S == null || S.length() == 0) {
            return out;
        }

        helper(S, out, 0);
        return out;
    }

    static boolean helper(String S, List<Integer> out, int index) {
        if(index == S.length() && out.size() >= 3) {
            return true;
        }


        for(int i = index; i < S.length(); i++) {
            if (S.charAt(index) == '0' && i > index) {
                break;
            }

            long num = Long.parseLong(S.substring(index, i+1));

            if(num > Integer.MAX_VALUE) {
                break;
            }

            int size = out.size();

            if (size >= 2 && num > out.get(size-1)+out.get(size-2)) {
                break;
            }

            if(size <= 1 || num == out.get(size-1)+out.get(size-2)) {
                out.add((int) num);
                if (helper(S, out, i+1)) {
                    return true;
                }
                out.remove(out.size()-1);
            }
        }
        return false;
    }
}
