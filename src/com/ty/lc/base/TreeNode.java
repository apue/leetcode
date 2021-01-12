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
}
