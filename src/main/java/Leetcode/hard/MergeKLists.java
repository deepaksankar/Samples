package main.java.Leetcode.hard;

import java.util.PriorityQueue;

public class MergeKLists {
    public static void main(String[] args) {
        System.out.println("Done");
    }

    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode list : lists) {
            while(list != null) {
                minHeap.add(list.val);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while(!minHeap.isEmpty()) {
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }

        return dummy.next;
    }
}
