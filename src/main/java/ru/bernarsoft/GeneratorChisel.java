package ru.bernarsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static ru.bernarsoft.Main.isChecker;

public class GeneratorChisel implements Runnable{

    private Queue<Integer> intQueue;
    private Object lock;

    public GeneratorChisel(Object lock, Queue<Integer> intQueue) {
                this.lock = lock;
                this.intQueue = intQueue;
    }

    public void run() {


        while(isChecker()) {

            synchronized (lock) {
                lock.notify();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random randNumber = new Random();
            int iNumber = randNumber.nextInt(99);
            intQueue.add(iNumber);

        }

    }


}
