package main.java.GFG;

/**
 * Given an array of numbers find the equilibrium index so that
 */
public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] inputArr = {-4, 3, 0, 2, 5, 1, -7};
        int[] inputArr1 = {1, 7, 3, 6, 5, 6};
        int[] inputArr2 = {1, 2, 3};
        int[] inputArr3 = {};
        int out = findEquilibrium(inputArr3);
        System.out.println("Equilibrium index is " + out);
    }

    static int findEquilibrium(int[] array) {
        if(array == null || array.length == 0) {
            return -1;
        }
        int sum = 0;
        int leftSum = 0;
        int len = array.length;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        for(int i = 0; i < array.length; i++) {
            sum = sum - array[i];
            if(sum == leftSum) {
                return i;
            }
            leftSum += array[i];
        }
        return -1;
    }
}
