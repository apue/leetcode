package com.ty.lc.problems;

import com.ty.lc.base.TreeNode;

import static com.ty.lc.base.TreeNode.BFS;

public class _0654_Max_Binary_Tree {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return innerMax(nums, 0, nums.length - 1);
    }

    static TreeNode innerMax(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxIndex = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxVal) {
                maxIndex = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = innerMax(nums, start, maxIndex - 1);
        root.right = innerMax(nums, maxIndex + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode root = constructMaximumBinaryTree(nums);
        BFS(root);
    }
}
