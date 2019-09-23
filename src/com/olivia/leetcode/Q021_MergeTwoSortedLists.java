package com.olivia.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * <p>
 * dummy node
 */
public class Q021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            boolean chk = (l1.val < l2.val);
            curr.next = chk ? l1 : l2;
            curr = curr.next;
            l1 = chk ? l1.next : l1;
            l2 = chk ? l2 : l2.next;
        }
        curr.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }

}
