package com.olivia.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//负数认为第一个参数放前面，记住这一条就行

public class Demo02_Comparator {

    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 50);
        Student student2 = new Student("B", 2, 22);
        Student student3 = new Student("C", 3, 33);
        Student[] students = new Student[]{student3, student1, student2};
        printStudents(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator());
        heap.add(student3);
        heap.add(student2);
        heap.add(student1);
        System.out.println("--");
        while (!heap.isEmpty()) {
            Student s = heap.poll();
            System.out.println("Name: " + s.name + ", Id : " + s.id + ", Age : " + s.age);
        }
    }

    public static void printStudents(Student[] students) {
        System.out.println("====================");
        for (Student s : students) {
            System.out.println("Name: " + s.name + ", Id : " + s.id + ", Age : " + s.age);
        }
    }

    public static class Student{
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            //return 负数 o1小，放在前面；return 正数o2小，放在前面；return 0 一样大
            return o1.id - o2.id;

            //负数认为第一个参数放前面，记住这一条就行
        }
    }

    public static class IdDescendingComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }

    }


}
