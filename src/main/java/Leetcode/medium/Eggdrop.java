package main.java.Leetcode.medium;

/**
 * Space complexity - O(nk)
 * Time complexity - O(nk^2)
 */
public class Eggdrop {
    public static void main(String[] args) {
        int numOfEggs = 2;
        int numofFloors = 6;
        int chance = 0;
        int[][] dp = new int[numOfEggs+1][numofFloors+1];

        for(int i = 0; i <= numofFloors; i++) {
            dp[1][i] = i;
        }

        for (int eggs= 2; eggs <= numOfEggs; eggs++) {
            for(int floors = 1; floors <= numofFloors; floors++) {
                dp[eggs][floors] = Integer.MAX_VALUE;
                for (int k = 1; k <= floors; k++) {
                    chance = 1 + Math.max(dp[eggs-1][k-1], dp[eggs][floors-k]);
                    if (chance < dp[eggs][floors]) {
                        dp[eggs][floors] = chance;
                    }
                }
            }
        }
        System.out.println("Min number of tries is " + dp[numOfEggs][numofFloors]);
    }
}
