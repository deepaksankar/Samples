package main.java.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find if there is a path in the tree
 */
public class PathSumII {
    public static void main(String[] args) {
        List<List<Integer>> paths = new ArrayList<>();
        TreeNode root = new TreeNode(1);
        int sum = 22;
        sumInTree(root, sum, new ArrayList<Integer>(), paths);
    }

    static void sumInTree(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> paths) {
        if(root == null) {
            return;
        }
        if(root.val == sum && root.left == null && root.right == null) {
            paths.add(currentPath);
        }
        currentPath.add(root.val);

        sumInTree(root.left, sum-root.val, new ArrayList<>(currentPath), paths);
        sumInTree(root.right, sum-root.val, new ArrayList<>(currentPath), paths);
    }
}
