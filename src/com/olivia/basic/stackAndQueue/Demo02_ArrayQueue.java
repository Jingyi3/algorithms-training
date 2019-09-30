package com.olivia.basic.stackAndQueue;

//用数组实现大小固定的队列和栈 size = initSize
public class Demo02_ArrayQueue {
    private Integer[] arr;
    private Integer size;//size means the number of elements in this array
    private Integer start;
    private Integer end;

    public Demo02_ArrayQueue(int initSize) {
        if (initSize < 0)
            throw new IllegalArgumentException("The init size is less than 0");
        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }

    public Integer peek() {
        if (size == 0) return null;
        return arr[start];
    }

    public void Push(int obj) {
        if (size == arr.length)
            throw new IllegalArgumentException("the queue is full");
        size++;
        arr[end] = obj;
        end = end == arr.length - 1 ? 0 : end - 1;
        //循环数组 如果end到底并且整个数组没有装满，end 就回到开头
    }

    public Integer poll() {
        if (size == 0)
            throw new IllegalArgumentException("the queue is empty");
        size--;
        int tmp = start;
        start = start == arr.length - 1 ? 0 : start - 1;
        //循环数组 如果start取到最底下的一个数，就回到队头
        return arr[tmp];
    }

}
