package ru.quazar.l01;

import java.util.Random;

public class Main {

    final static int minRange = 0;
    final static int maxRange = 999;
    static int rndNumber;

    public static void main(String[] args) {
        CustomList list = new CustomList();
        for (int i = minRange; i < 100; i++) {
            Random rnd = new Random();
            rndNumber = minRange + rnd.nextInt(maxRange - minRange + 1);
            list.add(rndNumber);
        }

        MinimumClass<Integer> minClass = new MinimumClass<>();
        MaximumClass<Integer> maxClass = new MaximumClass<>();

        System.out.println("Минимальное значение:  " + (int) minClass.minElement(list));
        System.out.println("Максимальное значение: " + (int) maxClass.maxElement(list));
    }
}
