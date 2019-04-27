package main.java.Leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class BinaryPostOrderTraversal {
  public static void main(String[] args) {

  }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    helper(root, result);
    return result;
  }

  void helper(TreeNode root, List<Integer> result) {
    if(root == null) {
      return;
    }
    helper(root.left, result);
    helper(root.right, result);
    result.add(root.val);
  }
}
