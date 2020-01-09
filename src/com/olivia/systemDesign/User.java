package com.olivia.systemDesign;

public class User {
    public static void main(String[] args) {
        int i=0;
        while (i<5){
            while(i<4){
                i++;
                if (i==3) continue;
            }
            System.out.println(i);
            i++;
        }
    }
}
