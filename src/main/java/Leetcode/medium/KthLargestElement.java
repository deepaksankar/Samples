package main.java.Leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] input = {5, 2, 1, 3, 4, 0, 7, 9, 8, 10};
        //Strategy 1 - Using arrays sort. Run time - n logn
        int k = 3;
        int n = input.length;

        Arrays.sort(input);

        int num = input[n-k];

        System.out.println("Kth number is " + num);

        //Strategy 2 - Using heaps: Run time - n; Space - constant/n
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : input) {
            minHeap.add(i);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
        }

        int ans = minHeap.peek();

        System.out.println("Answer is " +ans);
    }
}
