package main.java.Leetcode.hard;

public class BuildBinaryTree2 {
    static int postOrder = 0;

    public static void main(String[] args) {
        int[] in = {2,1,3};
        int[] post = {2,3,1};

        postOrder = post.length-1;

        TreeNode node = buildTree(in, post);

        System.out.println(node);
    }

    static TreeNode buildTree(int[] in, int[] post) {
        if(in.length != post.length) {
            return null;
        }
        TreeNode root = build(in, post, 0, in.length-1);
        return root;
    }

    static TreeNode build(int[]in, int[] post, int inStart, int inEnd) {
        if(inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(post[postOrder--]);
        if(inStart == inEnd) {
            return node;
        }

        int inIndex = search(in, inStart, inEnd, node.val);

        node.left = build(in, post, inStart, inIndex-1);
        node.right = build(in, post, inIndex+1, inEnd);

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
