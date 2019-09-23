package com.olivia.leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Q024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null || dummy.next.next != null) {
            swap2(curr);
            curr = curr.next.next;
        }
        return dummy.next;
    }

    private void swap2(ListNode preNode) {
//        if (preNode.next == null || preNode.next.next == null) return;
        ListNode tempNode = preNode.next;
        preNode.next = tempNode.next;
        tempNode.next = tempNode.next.next;
        preNode.next.next = tempNode;
    }
}
