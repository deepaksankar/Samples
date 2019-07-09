package main.java.GFG;

public class Node {
    int data;
    Node left;
    Node right;
    Node nextRight;
    public Node(int data) {
        this.data = data;
        this.left = this.right = this.nextRight = null;
    }
}
