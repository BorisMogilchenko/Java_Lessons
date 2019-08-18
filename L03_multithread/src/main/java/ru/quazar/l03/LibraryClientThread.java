package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Random;
import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LibraryClientThread extends Thread {
    private static final int minRange = 1000;
    private static final int maxRange = 3000;

    private static Book booksCatalog;

    public Book getBooks(Book booksCatalog) {
        public void run() {
            int rndNumber;

            for (int i = 0; i < booksCatalog.size(); ++i) {
                Random rnd = new Random();
                rndNumber = minRange + rnd.nextInt(maxRange - minRange + 1);
                if (!(booksCatalog).get(i).getisBusy) {
                    booksCatalog.getBook(1);
                    try {
                        sleep(rndNumber);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    booksCatalog.get(i).setIsBusy(true);
                }
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
