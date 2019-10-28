package main.java.Leetcode.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserializeTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serial = serialize(root);
        System.out.println(serial);

        TreeNode out = deserialize(serial);
        System.out.println("Done");
    }
    // Encodes a tree to a single string.
    static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    static void preOrder(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null").append(",");
        } else {
            sb.append(root.val).append(",");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    static TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    static TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if(val.equals("null"))
            return null;
        else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }
}
