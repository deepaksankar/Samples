package main.java.Leetcode.easy;

public class PrintStringPermutations {
    public static void main(String[] args) {
        String input = "abc";
        printPermutations(input, 0, input.length()-1);
    }

    static void printPermutations(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
        }

        for (int i = l; i <= r; i++) {
            s = swap(s, i, l);
            printPermutations(s, l + 1, r);
            s = swap(s, i, l);
        }
    }

    static String swap(String s, int i, int j) {
        char[] sArr = s.toCharArray();
        char temp = sArr[i];
        sArr[i] = sArr[j];
        sArr[j] = temp;
        return String.valueOf(sArr);
    }
}
