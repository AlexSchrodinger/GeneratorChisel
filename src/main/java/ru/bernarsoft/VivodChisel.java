package ru.bernarsoft;


import java.util.*;

import static ru.bernarsoft.Main.isChecker;
import static ru.bernarsoft.Main.setCheckerFalse;

public class VivodChisel implements Runnable{

    private Map<Integer, Integer> map = new HashMap<>();
    private Queue<Integer> intQueue;
    private Object lock;
    private int count = 0;

    public VivodChisel(Object lock, Queue<Integer> intQueue) {
        this.lock = lock;
        this.intQueue = intQueue;
    }

    public void run() {

        while (isChecker()) {

            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(intQueue.peek() != null) {
                int tmp = intQueue.poll();
                if(!map.containsKey(tmp)) {
                    map.put(tmp, 1);
                }
                else {
                    map.replace(tmp, map.get(tmp) + 1);
                }

                if(count % 5 == 0) {
                    System.out.println("");
                    map.forEach((key, value) -> {
                        System.out.println(key + " повторилось - " + value + " раз");
                        if(value >= 5) {
                            setCheckerFalse();
                        }
                    });
                }
            }
        }



    }
}
