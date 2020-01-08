package com.olivia.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    static  ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                testsync();
            }
        };
        t1.setName("t1");
        Thread t2 = new Thread(){
            @Override
            public void run(){
                testsync();
            }
        };
        t2.setName("t2");
        t1.start();
        t2.start();



    }

    public static void testsync(){
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        finally {

            reentrantLock.unlock();
        }
    }
}
