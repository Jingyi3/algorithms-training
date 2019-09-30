package com.olivia.basic.stackAndQueue;

//用数组实现大小固定的队列和栈 size = initSize
public class Demo01_ArrayStack {
    private Integer[] arr;
    private Integer index;

    public Demo01_ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("This init size is less than 0");
        }
        arr = new Integer[initSize];
        index = 0;
    }

    public Integer peek() {
        if (index == 0) {
            return null;
        }
        return arr[index - 1];
    }

    public void push(int obj) {
        if (index == arr.length) {
            throw new IllegalArgumentException("the stack is full");
        }
        arr[index++] = obj;
    }

    public Integer pop() {
        if (index == 0) {
            throw new IllegalArgumentException("the stack is empty");
        }
        return arr[--index];
    }

}
