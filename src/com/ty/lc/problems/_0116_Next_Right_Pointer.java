package com.ty.lc.problems;

import com.ty.lc.base.Node;

public class _0116_Next_Right_Pointer {
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectNodes(root.left, root.right);
        return root;
    }

    private static void connectNodes(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        connectNodes(left.left, left.right);
        connectNodes(left.right, right.left);
        connectNodes(right.left, right.right);
    }
}
