package main.java.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SubLists {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = subList(nums);
        System.out.println(result);
    }

    static List<List<Integer>> subList(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }

    static void helper(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            helper(i+1, nums, current, subsets);
            current.remove(current.size()-1);
        }
    }
}
