package ru.bernarsoft;


public class Main {


    public static void main(String[] args) throws InterruptedException {
        Generator generator = new Generator();
        Thread thread = new Thread(new GeneratorChisel(generator));
        thread.start();
        Thread thread1 = new Thread(new VivodChisel());
        thread1.start();

        thread.join();
    }


}
