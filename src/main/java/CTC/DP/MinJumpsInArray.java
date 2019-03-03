package main.java.CTC.DP;

public class MinJumpsInArray {
    public static void main(String[] args) {
//        int[] inputArr = {1, 2, 6, 2, 1, 1};
        int[] inputArr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int minJumps = minNumOfJumps(inputArr);
        System.out.println("Min number of jumps " + minJumps);
    }

    static int minNumOfJumps(int[] arr) {
        if(arr.length == 0 || arr[0] == 0)
            return 0;
        int[] minJumps = new int[arr.length];
        if(arr[0] > arr.length - 1) {
            return 1;
        }
        int jump = 1;
        int steps = arr[0];
        int maxReach = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length-1)
                return jump;
            maxReach = Math.max(maxReach, i + arr[i]);

            steps -= 1;

            if (steps == 0) {
                jump++;

                if (i >= maxReach) {
                    return -1;
                }
                steps = maxReach - i;
            }
        }
        return -1;
    }
}
