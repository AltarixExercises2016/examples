package me.ilich.catdog;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Main {

    static Object o = new Object();

    public static void foo() {
        throw new RuntimeException();
    }

    public static void bar() throws IOException {
        throw new IOException();
    }

    static void work1() {
        try {
            work1();
        } finally {
            work1();
        }
    }

    public static void main(String[] args) {
        //work();


        work1();

/*        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a==b);
        System.out.println(c==d);*/
/*
        foo();
        try {
            bar();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

/*        Cat cat1 = new Cat(2, "black", 15);
        cat1.describeSelf();
        Cat cat2 = new Cat(2, "black", 15);
        cat2.describeSelf();*/

//        System.out.println(cat1.equals(cat2));
/*        Cat cat = Cat.createNewcat(cat1, cat2);
        cat.describeSelf();
        Fish fish = new Fish(1233);*/

/*        new Thread(new MyRunnableA()).start();
        new Thread(new MyRunnableB()).start();*/
    }

    private static void work() {
        work();
    }

    static class MyRunnableA implements Runnable {

        @Override
        public void run() {
            synchronized (o) {
                for (int i = 0; i < 5; i++) {
                    System.out.println("A" + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    static class MyRunnableB implements Runnable {

        @Override
        public void run() {
            synchronized (o) {
                for (int i = 0; i < 5; i++) {
                    System.out.println("B" + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
