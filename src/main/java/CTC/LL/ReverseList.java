package main.java.CTC.LL;

public class ReverseList {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        printList(node);

        node = reverseList(node);

        printList(node);

    }

    static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

        return head;
    }

    static void printList(Node head) {
        while(head.next != null) {
            System.out.print(head.data + "-> ");
            head = head.next;
        }
        System.out.println(head.data);
    }
}
