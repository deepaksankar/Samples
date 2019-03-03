package main.java.CTC.LL;

public class IntersectingLists {
    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        list1.next.next.next = new Node(4);
        list1.next.next.next.next = new Node(5);

        Node list2 = new Node(6);
        list2.next = new Node(4);
        list2.next.next = new Node(5);

        int interValue = intersectionNode(list1, list2);
        System.out.println("Value is " + interValue);
    }

    static int intersectionNode(Node list1, Node list2) {
        Node cur1 = list1;
        Node cur2 = list2;
        int len1 = 1;
        int len2 = 1;
        int diffLen;
        int intersection;
        while (cur1.next != null) {
            cur1 = cur1.next;
            len1++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            len2++;
        }
        if (cur1.data != cur2.data) {
            return Integer.MIN_VALUE;
        }
        if (len1 > len2) {
            diffLen = len1 - len2;
            intersection = findIntersection(list1, list2, diffLen);
        } else {
            diffLen = len2 - len1;
            intersection = findIntersection(list2, list1, diffLen);
        }
        return intersection;
    }

    static int findIntersection(Node node1, Node n2, int diff) {
        for (int i = 0; i < diff; i++) {
            node1 = node1.next;
        }

        while (node1.next != null && n2.next != null) {
            if (node1.data == n2.data) {
                return node1.data;
            }
            node1 = node1.next;
            n2 = n2.next;
        }
        return -1;
    }
}

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


