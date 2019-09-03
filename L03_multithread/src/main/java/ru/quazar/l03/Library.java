package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

@Data
@AllArgsConstructor
public class Library {
    private static final int workTime = 30000;
    private static final int minRange = 1000;
    private static final int maxRange = 3000;
    private static long START_TIME;

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        START_TIME = System.currentTimeMillis();
        String inFileName = "";
        int initialDelay = 0;
        int period = 250;

        System.out.println("TimerTask начал выполнение");

//        Book booksCatalog = new Book();
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(booksCatalog.size());

        GettingFile gettingFile = new GettingFile();

        if (args.length == 0) {
            inFileName = "";
        } else {
            inFileName = args[0];
        }

        ArrayList booksCatalog;
        try {
            File inputFile = gettingFile.getFileWithConditions(inFileName);
            booksCatalog = FileToBufStream.loadFileToStream(inputFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Количество книг в каталоге: " + booksCatalog.size());
        System.out.println();
        System.out.println("Перечень книг в каталоге:");
        for (Object bk : booksCatalog) {
            System.out.println("Название книги: " + bk);
            System.out.println();
            for (Book book : bk) {
                System.out.println("Название книги: " + book.getTitle());
                System.out.println("Наличие книги: " + (book.getBusy() ? "Нет" : "Да"));
            }
        }

        while (System.currentTimeMillis() - START_TIME < workTime) for (int i = 0; i < (booksCatalog).size(); i++) {
            scheduler.scheduleWithFixedDelay(new Runnable() {
                @Override
                public void run() {
                    int num = 0;
                    num++;
                    System.out.println("Scheduling Thread #" + num);
                }
            }, initialDelay, period, TimeUnit.MILLISECONDS);
            LibraryClientThread libraryClientThread = new LibraryClientThread();
            libraryClientThread.setName("Thread #" + i);
            libraryClientThread.start();
            int rndNumber;
            for (int i = 0; i < booksCatalog.size(); i++) {
                for (int k = 0, k < booksCatalog.get(i); k++){
                    if (!((Book) booksCatalog.get(i))) {
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
//            libraryClientThread.getBooks(booksCatalog);
        }
        scheduler.shutdownNow();
        int isFree = 0;
        for (int i = 0; i < booksCatalog.size(); i++) {
            if (booksCatalog.get(i)) {
                isFree++;
            }
        }
        System.out.println("Число запущенных потоков: " + ThreadStatus.getStatus());
        System.out.println();
        System.out.println("Количество книг в каталоге: " + isFree);
        System.out.println();
    }
}


