package ru.bernarsoft;


import java.util.ArrayList;
import java.util.Random;

public class Generator {

    public ArrayList<Integer> list = new ArrayList<Integer>();

    public synchronized void generate() throws InterruptedException {
        int counter = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random randNumber = new Random();
            int iNumber = randNumber.nextInt(99) + 1;
            System.out.println(iNumber);
            list.add(iNumber);
            counter++;
            if(counter == 5) {
                this.notifyAll();
            }

        }
    }



    public synchronized ArrayList<Integer> get() throws InterruptedException {
       while(!list.isEmpty());
        this.wait();
        this.notifyAll();
        return list;


    }
}
