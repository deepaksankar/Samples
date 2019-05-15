package main.java.Leetcode.hard;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 2, 0, 1, 0, 3, 0, 2, 1, 2};
        System.out.println(trap(height));
    }

    static int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int right = height.length-1;
        int left = 0;
        int leftMax = 0, rightMax = 0;
        int res = 0;

        while(left<=right) {
            if(height[left] < height[right]) {
                if(leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    res += leftMax-height[left];
                }
                left++;
            } else {
                if(rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    res += rightMax-height[right];
                }
                right--;
            }
        }
        return res;
    }
}
