package com.ty.lc.problems;

import com.ty.lc.base.TreeNode;

import static com.ty.lc.base.TreeNode.BFS;

public class _0105_Construct_Tree_From_Pre_In_Order {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return innerBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode innerBuildTree(int[] preorder, int preLo, int preHi, int[] inOrder, int inLo, int inHi) {
        if (inLo > inHi || preLo > preHi) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLo]);
        for (int i = inLo; i <= inHi; i++) {
            if (inOrder[i] == preorder[preLo]) {
                root.left = innerBuildTree(preorder, preLo + 1, preLo + i - inLo, inOrder, inLo, i - 1);
                root.right = innerBuildTree(preorder, preLo + i - inLo + 1, preHi, inOrder, i + 1, inHi);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        BFS(root);
    }
}
