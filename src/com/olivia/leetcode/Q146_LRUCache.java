package com.olivia.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q146_LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public Q146_LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;

    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);

    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    //     private Map<Integer, DLinkedNode> cache = new HashMap<>();
//     private int size;
//     private int capacity;
//     private DLinkedNode head, tail;

//     public LRUCache(int capacity) {
//         this.size = 0;
//         this.capacity = capacity;

//         head = new DLinkedNode();
//         // head prev is null

//         tail = new DLinkedNode();
//         // tail next is null

//         head.next = tail;
//         tail.prev = head;
//     }

//     public int get(int key) {
//         DLinkedNode node = cache.get(key);
//         if(node == null) return -1;

//         //move this node to the head because it is used frequently
//         moveToHead(node);
//         return node.value;

//     }

//     public void put(int key, int value) {
//         DLinkedNode node = cache.get(key);
//         if(node == null) {
//             DLinkedNode newnode = new DLinkedNode();
//             newnode.key = key;
//             newnode.value = value;

//             cache.put(key, newnode);
//             addNode(newnode);

//             size++;
//             if(size > capacity) {
//                 //pop the tail -- remove least recently used node
//                 DLinkedNode tail = popTail();
//                 cache.remove(tail.key);
//                 size--;
//             }
//         } else {
//             // update the value;
//             node.value = value;
//             moveToHead(node);
//         }


//     }


//     class DLinkedNode {
//         int key;
//         int value;
//         DLinkedNode prev;
//         DLinkedNode next;
//     }

//     private void addNode(DLinkedNode node) {
//         // add new node right after the head
//         node.prev = head;
//         node.next  = head.next;

//         head.next.prev = node;
//         head.next = node;
//     }

//     private void removeNode(DLinkedNode node) {
//         // remove an existing node from the Dlinked list
//         DLinkedNode prev = node.prev;
//         DLinkedNode next = node.next;

//         prev.next = next;
//         next.prev = prev;
//     }
//     private void moveToHead(DLinkedNode node) {
//         // move certain node in between to the head
//         removeNode(node);
//         addNode(node);

//     }

//     private DLinkedNode popTail() {
//         //pop current tail -- least recently used node
//         DLinkedNode res = tail.prev;
//         removeNode(res);
//         return res;
//     }
}
