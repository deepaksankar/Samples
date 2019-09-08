package main.java.Leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalTreeOrdering {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> out = verticalOrder(root);
        System.out.println(out);
    }

    static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> cols = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        cols.add(0);

        int min = 0;
        int max = 0;

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.remove();

            if(!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);

            if(node.left != null) {
                q.add(node.left);
                cols.add(col-1);
                min = Math.min(min, col-1);
            }

            if(node.right != null) {
                q.add(node.right);
                cols.add(col+1);
                max = Math.max(max, col+1);
            }
        }

        for(int i = min; i <= max; i++) {
            result.add(map.get(i));
        }

        return result;
    }
}
