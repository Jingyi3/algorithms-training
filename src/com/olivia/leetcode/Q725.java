package com.olivia.leetcode;

public class Q725 {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        if(head==null||k==0) return new ListNode[0];
        ListNode[] result = new ListNode[k];
        ListNode slow = head;
        ListNode fast = head;
        int len=0;
        while(fast!=null) {
            len++;
            fast=fast.next;
        }
        fast = head;
        if(k>=len) {
            for(int i=0; i<k; i++) {
                if(i<len) {
                    head = slow.next;
                    fast.next = null;
                    result[i] = fast;

                    slow = head;
                    fast = head;
                } else {
                    result[i] = null;
                }
            }
        } else {
            int leftover = len % k;
            int groupSize = len / k;
            for(int i = 0; i<k; i++) {
                int currSize = groupSize;
                if(leftover>0) {
                    currSize = groupSize+1;
                    leftover--;
                }
                for(int j=0; j<currSize-1; j++) {
                    fast = fast.next;
                }
                head = fast.next;
                fast.next = null;
                result[i] = slow;
                slow = head;
                fast = head;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(3);
        tmp = tmp.next;
        tmp.next = new ListNode(4);
        tmp = tmp.next;
        tmp.next=null;
        tmp = head;
//        while(tmp!=null){
//            System.out.println(tmp.val);
//            tmp = tmp.next;
//        }
        ListNode[] result = splitListToParts(head, 3);
        for (int i = 0; i < 3; i++) {
            ListNode curNode = result[i];
            if (curNode == null) {
                System.out.println("this is " + i + " level : null");
            }
            while (curNode != null) {
                System.out.println("this is " + i + " level : " + curNode.val);
                curNode = curNode.next;
            }
        }

    }
}
