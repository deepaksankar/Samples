package main.java.Leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    List<List<Integer>> out = zigzagLevelOrder(root);
    System.out.println(out);
  }
  static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) {
      return result;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    boolean flag = true;

    while(!q.isEmpty()) {
      int size = q.size();
      List<Integer> currentLevel = new ArrayList<>();
      for(int i = 0; i < size; i++) currentLevel.add(0); // initialize
      for(int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        if(flag) {
          currentLevel.set(i, cur.val);
        } else {
          currentLevel.set(size-1-i, cur.val);
        }
        if(cur.left != null) {
          q.offer(cur.left);
        }
        if(cur.right != null) {
          q.offer(cur.right);
        }
      }
      result.add(currentLevel);
      flag = !flag; //flip the flag at every level
    }

    return result;
  }
}
