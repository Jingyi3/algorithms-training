package com.olivia.basic;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，在实现赶回栈中最小元素的操作
 * 要求：
 * 1. pop, push, getMin 操作的时间复杂度都是O(1)
 * 2. 设计额栈类型可以实现现成的栈结构
 * <p>
 * 解决：
 * 使用两个栈
 * <p>
 * 两种解决方法
 * 1. 两个栈不同时push
 * 2. 两个栈同时push
 */
public class Demo05_GetMinStack {
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getMin()) {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            int value = this.stackData.pop();
            if (value == this.getMin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            return this.stackMin.peek();
        }
    }

    public static class MyStack2{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()||newNum<this.stackMin.peek())
                this.stackMin.push(newNum);
            else{
                this.stackMin.push(this.stackMin.peek());
            }
            this.stackData.push(newNum);
        }

        public Integer pop() {
            if (this.stackData.isEmpty())
                throw new RuntimeException("Your stack is empty");
            this.stackMin.pop();
            return this.stackData.pop();
        }

        public Integer getMin() {
            if(this.stackData.isEmpty())
                throw new RuntimeException("Your stack is empty");
            return this.stackMin.pop();
        }
    }
}
