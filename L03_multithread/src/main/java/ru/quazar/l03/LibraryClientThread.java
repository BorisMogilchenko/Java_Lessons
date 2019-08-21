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

    public void getBooks(Book booksCatalog) {
        int rndNumber;

        for (int i = 0; i < booksCatalog.size(); ++i) {
            Random rnd = new Random();
            rndNumber = minRange + rnd.nextInt(maxRange - minRange + 1);
            if (!booksCatalog.getBusy()) {
                booksCatalog.getBook(1);
                try {
                    sleep(rndNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                booksCatalog.setBusy(true);
            }
        }
    }

    public Book supplyBooks() {
/*        private final ArrayList<Book> booksCatalog;
        private getBooks(ArrayList<Book> booksCatalog) {
            this.booksCatalog = booksCatalog;
        }*/
    }

}
