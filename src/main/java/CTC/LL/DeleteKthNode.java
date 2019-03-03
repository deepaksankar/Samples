package main.java.CTC.LL;

public class DeleteKthNode {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);

        Node res = deleteKthNode(n1, 3);

        System.out.println("Node might be deleted" + res);
    }

    static Node deleteKthNode(Node n, int k) {
        if (n == null)
            return null;
        Node cur = n;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len += 1;
        }
        if (k > len) {
            return null;
        }
        Node fast = n;
        for (int i = k; i >0; i--) {
            fast = fast.next;
        }
        Node slow = n;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return slow;
    }
}
