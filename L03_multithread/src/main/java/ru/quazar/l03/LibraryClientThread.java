package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LibraryClientThread extends Thread {
    private static final int minRange = 1000;
    private static final int maxRange = 3000;

/*    boolean getBooks(ArrayList booksCatalog) {
        int rndNumber;
        for (ArrayList bk : booksCatalog) {
            for (Book el : bk) {
                if (!(el.getBusy())) {
                    Random rnd = new Random();
                    rndNumber = minRange + rnd.nextInt(maxRange - minRange + 1);
                    el.waitAndSupply(1, rndNumber);
                    try {
                        el.getBook(1);
                        sleep(rndNumber);
                        el.putBook(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    el.setBusy(true);
                }
            }
        }
    }*/
}
