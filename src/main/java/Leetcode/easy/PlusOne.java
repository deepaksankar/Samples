package main.java.Leetcode.easy;

public class PlusOne {
    public static void main(String[] args) {
        int[] input = {1, 2, 9};
        int[] out = plusOne(input);
        System.out.println("Done");
    }

    static int[] plusOne(int[] in) {
        if(in.length == 0) {
            return new int[1];
        }

        for(int i = in.length-1; i >= 0; i--) {
            if(in[i] < 9) {
                in[i]++;
                return in;
            }
            in[i] = 0;
        }
        int[] result = new int[in.length+1];
        result[0] = 1;

        return result;
    }
}
