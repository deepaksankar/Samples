package main.java.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SumofSubArray {
    public static void main(String[] args) {
        int[] inputArr = {1, 1, 1};
        int sum = 2;
        int arrayCount = subarraySum(inputArr, sum);
        System.out.println("Number of sub arrays is " + arrayCount);
    }

    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        if (nums.length == 0)
            return 0;
        int[] sums = new int[nums.length+1];
        int tempSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            sums[i+1] = tempSum;
        }
        return count;
    }
}
