package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Random;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LibraryClientThread extends Thread {
    private static final int minRange = 1000;
    private static final int maxRange = 3000;

    @Override
    public void run() {
        int rndNumber;

        for (int i = 0; i < names.length; i++) {
            System.out.println("Обработаны документы: " + names[i]);
            Random rnd = new Random();
            rndNumber = minRange + rnd.nextInt(maxRange - minRange + 1);
            try {
                sleep(rndNumber);
            } catch (Exception e) {}
        }
    }

    synchronized void getBook(int amount) {
        checkAmountNotNegative(amount);
//        quantity -= amount;
        notifyAll();
    }

    synchronized void putBook(int amount) {
        checkAmountNotNegative(amount);
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount of books");
        }
//        quantity += amount;
    }

    void waitAndSupply(int amount) {
        checkAmountNotNegative(amount);
        while (quantity < amount) {
            try {
                wait(rnd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        quantity -= amount;
    }

    private void checkAmountNotNegative(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount of books");
        }
    }

}
