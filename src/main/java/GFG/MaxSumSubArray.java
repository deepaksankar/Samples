package main.java.GFG;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4, 5, 6, 3, -7};
        int sum = maxSum(nums, nums.length);
        System.out.println("Maximum sum is " + sum);
    }

    static int maxSum(int[] nums, int size) {
        int sum_so_far = 0, sum_end_here = 0;
        sum_end_here = nums[0];

        for(int i = 1; i < size; i++) {
            sum_end_here = Math.max(nums[i], sum_end_here+nums[i]);
            sum_so_far = Math.max(sum_so_far, sum_end_here);
        }
        return sum_so_far;
    }
}
