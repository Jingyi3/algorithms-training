package com.olivia.lock;

import java.util.concurrent.locks.LockSupport;

public class TestPark {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run(){
                testsync();
            }


        };

        t1.setName("t1");
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main----1");
        LockSupport.unpark(t1);//立马叫醒

    }

    public static void testsync(){
        System.out.println(Thread.currentThread().getName());
        LockSupport.park();//让线程立马睡眠


        System.out.println("end-----t1-2");
    }
}
