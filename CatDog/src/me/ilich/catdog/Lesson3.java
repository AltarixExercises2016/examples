package me.ilich.catdog;

import java.util.LinkedList;
import java.util.Random;

public class Lesson3 {

    private static final Random random = new Random();
    private static final LinkedList<String> list = new LinkedList<>();
    private static boolean working = true;

    private static final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private static String randomString() {
        int len = random.nextInt(10) + 5;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int letterIndex = random.nextInt(letters.length);
            String s = letters[letterIndex];
            sb.append(s);
        }
        return sb.toString();
    }


    private static void sleep() {
        int pause = random.nextInt(2000) + 1000;
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] arg) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    private static class Producer implements Runnable {

        @Override
        public void run() {
            while (working) {
                synchronized (list) {
                    String item = randomString();
                    list.add(item);
                    int listSize = list.size();
                    System.out.println("add " + listSize + " " + item);
                }
                sleep();
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {
            while (working) {
                synchronized (list) {
                    if (list.size() == 0) {
                        working = false;
                    } else {
                        int listSize = list.size();
                        int itemIndex = random.nextInt(listSize);
                        String item = list.remove(itemIndex);
                        System.out.println("remove " + itemIndex + " / " + listSize + " " + item);
                    }
                }
                sleep();
            }
        }
    }


}
