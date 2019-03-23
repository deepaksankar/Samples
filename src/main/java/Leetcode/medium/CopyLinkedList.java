package main.java.Leetcode.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class CopyLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
    }

    static Node copyRandomList(Node head) {
        Map<Node, Node> oldNewMapping = new LinkedHashMap<>();

        Node iter = head;

        while(iter != null) {
            oldNewMapping.put(iter, new Node(iter.val, null, null));
            iter = iter.next;
        }

        iter = head;

        while (iter != null) {
            oldNewMapping.get(iter).next = oldNewMapping.get(iter.next);
            oldNewMapping.get(iter).random = oldNewMapping.get(iter.random);
            iter = iter.next;
        }

        return oldNewMapping.get(head);
    }
}
