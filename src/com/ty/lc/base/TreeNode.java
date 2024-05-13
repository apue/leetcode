package com.ty.lc.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int x) {
    val = x;
  }

  public TreeNode(int x, TreeNode left, TreeNode right) {
    val = x;
    this.left = left;
    this.right = right;
  }

  public static void BFS(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<>();
    depth(root, 1, ret);
    for (List<Integer> list : ret) {
      for (Integer i : list) {
        System.out.print(i + " ");
      }
      System.out.println();
    }

  }

  private static void depth(TreeNode root, int depth, List<List<Integer>> list) {
    if (root == null) {
      return;
    }
    if (depth > list.size()) {
      list.add(new ArrayList<>());
    }
    list.get(depth - 1).add(root.val);
    depth(root.left, depth + 1, list);
    depth(root.right, depth + 1, list);
  }

  public static TreeNode buildTree(Integer[] levelOrder) {
    if (levelOrder == null || levelOrder.length == 0) return null;

    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(levelOrder[0]);
    queue.add(root);

    for (int i = 1; i < levelOrder.length; i+=2) {
      TreeNode current = queue.poll();
      if (levelOrder[i] != null) {
        current.left = new TreeNode(levelOrder[i]);
        queue.add(current.left);
      }
      if (i + 1 < levelOrder.length && levelOrder[i + 1] != null) {
        current.right = new TreeNode(levelOrder[i + 1]);
        queue.add(current.right);
      }
    }

    return root;
  }

  public static void main(String[] args) {
    Integer[] array = new Integer[] {3, 9, 20, null, null, 15, 7};
    TreeNode root = buildTree(array);
    BFS(root);
  }

}
