package main.java.Leetcode.easy;

public class ReverseInteger {
    public static void main(String[] args) {
        int out = reverse(1534236469);
        System.out.println(out);
    }
    static int reverse(int x) {
        boolean neg = false;
        if(x < 0) {
            neg = true;
            x = x * -1;
        }
        long result = 0;

        while(x > 0) {
            result = (result*10) + (x%10);
            x /= 10;
        }

        if(result > Integer.MAX_VALUE)
            return 0;

        return neg ? (int) result*-1 : (int)result;
    }
}
