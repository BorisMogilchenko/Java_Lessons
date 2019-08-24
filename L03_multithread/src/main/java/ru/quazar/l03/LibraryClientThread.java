package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LibraryClientThread extends Thread {
    private static final int minRange = 1000;
    private static final int maxRange = 3000;

    boolean getBooks(Book booksCatalog) {
        int rndNumber;
        for (Book bk : booksCatalog) {
            if (!(bk.getBusy())) {
                Random rnd = new Random();
                rndNumber = minRange + rnd.nextInt(maxRange - minRange + 1);
                booksCatalog.waitAndSupply(1, rndNumber);
                try {
                    booksCatalog.getBook(1);
                    sleep(rndNumber);
                    booksCatalog.putBook(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                booksCatalog.setBusy(true);
            }
        }
    }
}
