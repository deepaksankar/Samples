package main.java.CTC.Strings;

public class AddingTwoNumbers {
    public static void main(String[] args) {
        String s1 = "256";
        String s2 = "789";

        String out = sum(s1, s2);

        System.out.println(out);
    }

    static String sum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int i = len1-1; int j = len2-1;
        int carry = 0;
        StringBuilder out = new StringBuilder();

        while(i >= 0 || j >= 0 || carry == 1) {
            int val1 = i < 0 ? 0: s1.charAt(i) - '0';
            int val2 = j < 0? 0 : s2.charAt(j) - '0';
            out.append((val1+val2+carry) %10);
            carry = (val1+val2+carry)/10;
        }

        return out.reverse().toString();
    }
}
