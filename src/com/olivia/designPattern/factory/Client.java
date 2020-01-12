package com.olivia.designPattern.factory;

public class Client {
    public static void main(String[] args) {
        Factory factory = new Factory();
        BMW bmw200 = factory.createBMW(200);
        BMW bmw333 = factory.createBMW(333);
    }
}
