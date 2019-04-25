package main.java.Leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a number check if the sum of square of its number is equal to 1 in n-iterations
 */
public class HappyNumber {
    public static void main(String[] args) {
        int input = 90;
        if(checkIfHappyNumber(input)) {
            System.out.println("It's a happy number");
        } else {
            System.out.println("It's not a happy number");
        }
    }

    static boolean checkIfHappyNumber(int n) {

        Set<Integer> hasOccurred = new HashSet<>();
        hasOccurred.add(n);

        while(n != 1) {
            int current = n;
            int sum = 0;
            while(current > 0) {
                sum += (current%10)*(current%10);
                current /= 10;
            }

            if(hasOccurred.contains(sum)) {
                return false;
            }

            hasOccurred.add(sum);
            n = sum;
        }

        return true;
    }
}
