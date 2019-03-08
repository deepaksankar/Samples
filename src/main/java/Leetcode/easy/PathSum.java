package main.java.Leetcode.easy;

public class PathSum {
    public static void main(String[] args) {

    }

    static boolean hasPath(TreeNode root, int sum) {
        if(root == null) {
            return false;
        } else if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        } else {
            return hasPath(root.left, sum-root.val) || hasPath(root.right, sum-root.val);
        }
    }
}
