package main.java.CTC.DP;

public class Coins {
    public static void main(String[] args) {
        int amount = 100;
        int ways = makeChange(amount);
        System.out.println("ways is " + ways);
    }

    static int makeChange(int n) {
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[n+1][denoms.length];
        return makeChange(n, denoms, 0, map);
    }

    static int makeChange(int amt, int[] denoms, int index, int[][] map) {
        if(map[amt][index] > 0) {
            return map[amt][index];
        }
        if (index >= denoms.length-1) {
            return 1;
        }
        int ways = 0;
        int denomAmount = denoms[index];
        for(int i = 0; i * denomAmount <= amt; i++) {
            int amountRemaining = amt - (i*denomAmount);
            ways += makeChange(amountRemaining, denoms, index+1, map);
        }
        map[amt][index] = ways;
        return ways;
    }
}
