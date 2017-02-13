package ru.bernarsoft;

import java.util.ArrayList;
import java.util.Random;

public class GeneratorChisel implements Runnable{

    private Generator generator;

    public GeneratorChisel(Generator generator) {
        this.generator = generator;
    }

    public ArrayList<Integer> list = new ArrayList<Integer>();

    public void run() {
        try {
            generator.generate();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
