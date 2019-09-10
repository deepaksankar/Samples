package main.java.Leetcode.medium;

import java.util.Arrays;

/**
 * Find the sum of modulo of all elements within the given array.
 */
public class SumOfModulo {
    static int mod = (int)(1e9 + 7);
    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 3};
        int out = sumModulo(input, input.length);
        System.out.println(out);
    }

    static int sumModulo(int[] arr, int N) {
        int max = Arrays.stream(arr).max().getAsInt();

        int[] cnt = new int[max+1];

        for(int i = 0; i < N; i++) {
            cnt[arr[i]]++;
        }

        long ans = 0;
        for(int i = 1; i <= max; i++) {
            for(int j = 1; j <= max; j++) {
                ans += cnt[i]*cnt[j]*(i%j);
                ans %= mod;
            }
        }

        return (int)ans;
    }
}
