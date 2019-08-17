package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Random;

@Data
@AllArgsConstructor
class LibraryClientThread extends Thread {
    private static final int minRange = 1000;
    private static final int maxRange = 3000;

    private static ArrayList booksCatalog;

    public LibraryClientThread(ArrayList<Book> booksCatalog) {
        this.booksCatalog = booksCatalog;
    }
    @Override
    public void run() {
        int rndNumber;

        for (int i = 0; i < booksCatalog.size(); ++i) {
            Random rnd = new Random();
            rndNumber = minRange + rnd.nextInt(maxRange - minRange + 1);
            if (!booksCatalog.get(i).getBusy()) {
//                    Catalog.outputCatalog(1);
                try {
                    sleep(rndNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                booksCatalog.get(i).setBusy(true);
            }
        }
    }

    public static  supplyBooks() {
        private final ArrayList<Book> booksCatalog;
        private BookOutputThread(ArrayList<Book> booksCatalog) {
            this.booksCatalog = booksCatalog;
        }
    }

}