package main.java.Leetcode.hard;

/**
 * Given 2 arrays, one in in-order traversal and another in pre-order traversal, build the binary tree,
 */
public class BuildBinaryTree {
    static int preOrder = 0;

    public static void main(String[] args) {
        int[] in = {2,1,3};
        int[] pre = {1,2,3};

        TreeNode node = buildTree(in, pre);

        System.out.println(node);
    }

    static TreeNode buildTree(int[] in, int[] pre) {
        if(in.length != pre.length) {
            return null;
        }
        TreeNode root = build(in, pre, 0, in.length-1);
        return root;
    }

    static TreeNode build(int[]in, int[] pre, int inStart, int inEnd) {
        if(inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(pre[preOrder++]);
        if(inStart == inEnd) {
            return node;
        }

        int inIndex = search(in, inStart, inEnd, node.val);

        node.left = build(in, pre, inStart, inIndex-1);
        node.right = build(in, pre, inIndex+1, inEnd);

        return node;
    }

    static int search(int[] in, int inStart, int inEnd, int value) {
        int i;
        for(i = inStart; i < inEnd; i++) {
            if(in[i] == value) {
                return i;
            }
        }
        return i;
    }
}
