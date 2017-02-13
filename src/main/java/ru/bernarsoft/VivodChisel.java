package ru.bernarsoft;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VivodChisel implements Runnable{

    private Generator generator;
    ArrayList<Integer> list;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void run() {
        try {
            list = generator.get();
            for (int i = 0; i < list.size(); i++) {
                Integer tmpInt = list.get(i);

                if (!map.containsKey(tmpInt)) {
                    map.put(tmpInt, 1);
                } else {
                    map.put(tmpInt, map.get(tmpInt) + 1);
                }

                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + " Повторений = " + entry.getValue());
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
