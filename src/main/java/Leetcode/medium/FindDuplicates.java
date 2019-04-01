package main.java.Leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(4);
        List<Integer> out = findDuplicatesWithSpace(input);
        System.out.println(out);

        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> out1 = findDuplicates(nums);
        System.out.println(out1);
    }

    static List<Integer> findDuplicatesWithSpace(List<Integer> input) {
        if(input == null || input.size() <= 1) {
            return new ArrayList<>();
        }
        Set<Integer> set = new LinkedHashSet<>();
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if(set.contains(input.get(i))) {
                output.add(input.get(i));
            }
            set.add(input.get(i));
        }

        return output;
    }

    static List<Integer> findDuplicates(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                output.add(Math.abs(index+1));
            }
            nums[index] = -nums[index];
        }

        return output;
    }
}
