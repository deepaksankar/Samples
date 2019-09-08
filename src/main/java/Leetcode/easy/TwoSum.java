package main.java.Leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, -5};
        int target = -8;
        int[] result = twoSum(nums, target);
        System.out.println(result);
    }
    static int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        if (nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(target-nums[i], i);
            }
        }
        return result;
    }
}
