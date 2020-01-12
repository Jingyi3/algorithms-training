package com.olivia.designPattern.factory;

public class BMW333Factory implements Factory2 {
    @Override
    public BMW createBMW() {
        return new BMW333();
    }
}
