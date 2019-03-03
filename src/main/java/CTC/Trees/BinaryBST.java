package main.java.CTC.Trees;

public class BinaryBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        boolean isBST = isTreeABST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println("The tree is a BST " + isBST);
    }

    static boolean isTreeABST(TreeNode root, long min, long max) {
        if(root == null)
            return true;
        if(root.value > max || root.value < min) {
            return false;
        }
        return isTreeABST(root.left, min, root.value) && isTreeABST(root.right, root.value, max);
    }
}
