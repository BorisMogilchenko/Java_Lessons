package ru.quazar.l01;

import lombok.Data;

import java.util.Random;

@Data
public class Main {

    private static final int minRange = 0;
    private static final int maxRange = 999;
    private static final int cycleCounter = 100;
    private static int rndNumber;

    public static void main(String[] args) {
        CustomList list = new CustomList();
        for (int i = minRange; i < cycleCounter; i++) {
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
