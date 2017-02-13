package ru.bernarsoft;


import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static Boolean checker = true;


    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> intQueue = new LinkedList<Integer>();

        Object lock = new Object();

        Thread thread = new Thread(new GeneratorChisel(lock, intQueue));
        thread.start();
        Thread thread1 = new Thread(new VivodChisel(lock, intQueue));
        thread1.start();

//        thread.join();
//        thread1.join();
    }

    public static Boolean isChecker() {
        return checker;
    }

    public static void setCheckerFalse() {
        checker = false;
    }

}
