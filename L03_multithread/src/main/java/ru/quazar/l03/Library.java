package ru.quazar.l03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Library {

    public static void main(String[] args) {

        ArrayList<Book> booksCatalog = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("E://Backup//books.txt");
             InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
             BufferedReader bufRead = new BufferedReader(isr)
        ) {
            String line;
            while ((line = bufRead.readLine()) != null) {
                booksCatalog.add(new Book(line, false));
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        for (Book bk : booksCatalog) {
            System.out.println("Название книги: " + bk.getTitle());
            System.out.println("Наличие книги: " + (bk.getBusy() ? "Нет" : "Да"));
        }

        while (new Catalog().getQuantity() > 0) {
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(booksCatalog.size());

            Runnable task = () -> System.out.println("Schedulling: " + System.nanoTime());

            int initialDelay = 0;
            int period = 250;

            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }

            scheduler.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.MILLISECONDS);
        }

    }
}

class LibraryClientThread extends Thread {
    private static final int minRange = 1000;
    private static final int maxRange = 3000;
    private static int rndNumber;

    private static ArrayList booksCatalog;

    public LibraryClientThread() {
        this(booksCatalog);
    }

    public LibraryClientThread(ArrayList<Book> booksCatalog) {
        this.booksCatalog = booksCatalog;
    }

    public static class BookOutputThread extends Thread {
        private final ArrayList<Book> booksCatalog;

        private BookOutputThread(ArrayList<Book> booksCatalog) {
            this.booksCatalog = booksCatalog;
        }

        @Override
        public void run() {
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
    }
}


