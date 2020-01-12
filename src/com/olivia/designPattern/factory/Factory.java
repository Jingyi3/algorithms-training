package com.olivia.designPattern.factory;

public class Factory {
    public BMW createBMW(int type) {
        switch (type) {
            case 200:
                return new BMW200();

            case 333:
                return new BMW333();
            default:
                break;

        }
        return null;
    }
}
