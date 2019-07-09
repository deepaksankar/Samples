package main.java.GFG;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Connect all nodes at the same level in a binary tree.
 */
public class ConnectNodes {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        connectingLevelNodes(root);
        System.out.println("Done");
    }

    static void connectingLevelNodes(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); // Because there is only one element in this level.

        while(!q.isEmpty()) {
            Node temp = q.remove();
            if(temp != null) {
                temp.nextRight = q.peek();
                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            } else if(!q.isEmpty()) {
                q.add(null); //Adding a null to point the end of the next level
            }
        }
    }
}
