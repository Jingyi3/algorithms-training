package com.olivia.basic.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Demo05_DogCatQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog(String type) {
            super(type);
        }
    }

    public static class Cat extends Pet {
        public Cat(String type) {
            super(type);
        }
    }


    public static class PetEnter {
        private Pet pet;
        private long count;

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }

    public static class DogCatQueue {
        private Queue<PetEnter> dogQ;
        private Queue<PetEnter> catQ;
        private long count;//相当于 时间戳
        public DogCatQueue() {
            this.dogQ = new LinkedList<>();
            this.catQ = new LinkedList<>();
            this.count = 0;
        }

        public void add(Pet pet) {

        }
    }
}

