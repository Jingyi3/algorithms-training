package com.olivia.leetcode;

import java.util.Stack;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Note:
 * <p>
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class Q025_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre != null) {
            pre = reverse(pre, k);
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode pre, int k) {
        ListNode last = pre;
        for (int i = 0; i < k + 1; i++) {
            last = last.next;
            if (i != k && last == null) return null;
        }
        ListNode tail = pre.next;
        ListNode curr = pre.next.next;
        while (curr != last) {
            ListNode next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            tail.next = next;
            curr = next;
        }
        return tail;
    }

    public ListNode reverseKGroup_Stack(ListNode head, int k) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode next = dummy.next;
        while (next != null) {
            for (int i = 0; i < k && next != null; i++) {
                stack.push(next);
                next = next.next;
            }
            if (stack.size() != k) return dummy.next;
            while (stack.size() != 0) {
                current.next = stack.pop();
                current = current.next;
            }
            current.next = next;
        }
        return dummy.next;
    }
}
