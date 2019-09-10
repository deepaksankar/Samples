package main.java.Leetcode.easy;

/**
 * Remove elements from a list that equals to given value.
 */
public class RemoveElementFromAList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        ListNode result = removeElements(head, 6);
        while(result != null) {
            if(result.next == null) {
                System.out.println(result.val);
            } else {
                System.out.print(result.val + "-> ");
            }
            result = result.next;
        }
    }
    static ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) {
            head = head.next;
        }
        ListNode current = head;
        while(current != null && current.next != null) {
            if(current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
