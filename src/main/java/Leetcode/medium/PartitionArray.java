package main.java.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of positive numbers, identify if it can be split into two halves with same sum
 */
public class PartitionArray {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean canBe = canBePartitioned(nums);
    }

    static boolean canBePartitioned(int[] nums) {
        int total = 0;
        for(int i : nums) {
            total += i;
        }

        if(total % 2 != 0) {
            return false;
        }

        return canBePartitioned(nums, 0, 0, total, new HashMap());
    }

    static boolean canBePartitioned(int[] nums, int index, int sum, int total, Map<String, Boolean> state) {
        String cur = index+""+sum;
        if(state.containsKey(cur)) {
            return state.get(cur);
        }
        if(total == sum * 2) {
            return true;
        }
        if(sum > total/2 || index+1 >= nums.length) {
            return false;
        }
        boolean foundPartition = canBePartitioned(nums, index+1, sum, total, state) || canBePartitioned(nums, index+1, sum+nums[index], total, state);
        state.put(cur,foundPartition);
        return foundPartition;
    }
}
