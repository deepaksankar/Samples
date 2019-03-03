package main.java.CTC.Arrays;

/**
 * Given an array that is sorted, find an element in that array
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] inputArr = {3,4,5,6,1,2};
        int key = 7;
        int element = findElement(inputArr, 0, inputArr.length-1, key);
        if(element != -1)
            System.out.println("The element is "+element);
        else
            System.out.println("Key not found");
    }

    static int findElement(int[] array, int l, int r, int key) {
        if(l > r) {
            return -1;
        }
        int mid = (l + r)/2;
        if(array[mid] == key) {
            return mid;
        }
        if(array[l] <= array[mid]) {
            if(key >= array[l] && key <= array[mid]) {
                return findElement(array, l, mid-1, key);
            }
            return findElement(array, mid+1, r, key);
        }

        if(key >= array[mid] && key <= array[r]) {
            return findElement(array, mid+1, r, key);
        }
        return findElement(array, l, mid-1, key);
    }
}
