package com.ty.lc.base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void traverse(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        System.out.print(head.val);
        System.out.print(", ");
        if (head.next != null) {
            traverse(head.next);
        } else {
            System.out.println("NULL");
        }
    }
}
