package main.java.GFG;

/**
 * Find the sub array that would have the maximum product
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] inputArr = {1, -1, 2, 3, 1};
        int maxProduct = maxProduct(inputArr);
        System.out.println("Maximum product is " + maxProduct);
    }

    static int maxProduct(int[] array) {
        int max = array[0];
        int min = array[0];
        int imax = Integer.MIN_VALUE;
        int imin = Integer.MIN_VALUE;
        for(int i = 1; i < array.length; i++) {
            imax = Math.max(max, max*array[i]);
            imin = Math.min(min, min*array[i]);
            if(imax < 0) {
                swap(imax,imin);
            }

            if(max < imax) {
                max = imax;
            }
        }

        return max;
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
