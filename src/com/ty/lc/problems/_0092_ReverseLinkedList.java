package com.ty.lc.problems;

import com.ty.lc.base.ListNode;

public class _0092_ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode reverse3(ListNode a, ListNode b) {
        ListNode prev = null, curr = a;
        while (curr != b) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b = head;

        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse3(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public static ListNode reverse2(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode.traverse(head);
        ListNode reversed = reverse2(head);
        ListNode.traverse(reversed);
        _0092_ReverseLinkedList rev = new _0092_ReverseLinkedList();
        ListNode head2 = rev.reverseBetween(head, 2, 4);
        ListNode.traverse(head2);
    }
}
