package com.olivia.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * priority queue
 * Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.
 */
public class Q023_MergeKSortedLists {
    class NodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] listNodes) {
        ListNode dummy = new ListNode(0);
        if (listNodes == null || listNodes.length == 0) return dummy.next;
        int size = listNodes.length;
        ListNode curr = dummy;
        NodeComparator cmp = new NodeComparator();
        PriorityQueue<ListNode> pq = new PriorityQueue<>(cmp);
        for (int i = 0; i < size; i++) {
            if (listNodes[i] != null) {
                pq.add(listNodes[i]);
            }
        }
        while (pq.size() != 0) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null)
                pq.add(node.next);
        }
        return dummy.next;
    }
}
