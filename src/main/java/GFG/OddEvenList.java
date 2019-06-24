package main.java.GFG;

public class OddEvenList {
    public static void main(String[] args) {

    }

    static ListNode rearrange(ListNode head) {
        ListNode odd = head;
        ListNode even = odd.next;

        ListNode evenFirst = even;

        while(true) {
            if(odd == null || even == null || even.next == null) {
                odd.next = evenFirst;
                break;
            }
            odd.next = even.next;
            odd = even.next;

            if(odd.next == null) {
                even.next = null;
                odd.next = evenFirst;
                break;
            }
            even.next = odd.next;
            even = odd.next;
        }
        return head;
    }
}
