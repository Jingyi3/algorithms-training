package com.olivia.leetcode;

/**
 * 双指针
 */
public class Q061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode[] tmp = new ListNode[0];

        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while (fast != null) {
            len++;
            fast = fast.next;
        }
        fast = head;
        for (int i = 0; i < k % len; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
