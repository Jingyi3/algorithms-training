package com.olivia.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UsageOfCallable {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            int i = 0;
            for (; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());

            }
            return i;

        });
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "循环变量i的值 : " + i);
            if (i==2) new Thread(futureTask,"有返回值的thread！").start();
           System.out.println("--start--");
        }
        try {
            System.out.println("子线程的返回值"+ futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
