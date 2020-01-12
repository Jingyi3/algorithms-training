package com.olivia.designPattern.factory;

public class BMW200Factory implements Factory2 {
    @Override
    public BMW createBMW() {
        return new BMW200();
    }
}
