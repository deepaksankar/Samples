package main.java.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Identify the set of unique numbers in the given array that can equal to the given target sum.
 * Space complexity - O(n)
 * Time complexity - O(2^n)
 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] inputArr = {10,1,2,7,6,1,5};
        Arrays.sort(inputArr); //So that (6,2) is not returned after (2,6)
        int targetSum = 8;
        CombinationSumII c2 = new CombinationSumII();
        List<List<Integer>> result = c2.combinationSum2(inputArr, targetSum);
        System.out.println("Done");
    }

    List<List<Integer>> combinationSum2(int[] arr, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(arr, 0, sum, new ArrayList<>(), result);
        return result;
    }

    void combinationSum(int[] arr, int index, int sum, List<Integer> current, List<List<Integer>> result) {
        if(sum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(sum < 0) {
            return;
        }

        for(int i = index; i < arr.length; i++) {
            if(i == index || arr[i] != arr[i-1]) {
                current.add(arr[i]);
                combinationSum(arr, i+1, sum-arr[i], current, result);
                current.remove(current.size()-1);
            }
        }
    }
}
