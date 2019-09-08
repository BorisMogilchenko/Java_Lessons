package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Data
@AllArgsConstructor
public class Library {
    private static final int workTime = 30000;
    private static final int minRange = 1000;
    private static final int maxRange = 3000;
    private static long START_TIME;

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        START_TIME = System.currentTimeMillis();
        String inFileName = "";
        int initialDelay = 0;
        int period = 250;

        System.out.println("TimerTask начал выполнение");

//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(booksCatalog.size());

        GettingFile gettingFile = new GettingFile();

        if (args.length == 0) {
            inFileName = "";
        } else {
            inFileName = args[0];
        }

        File inputFile = gettingFile.getFileWithConditions(inFileName);
//        Book booksCatalog = FileToBufStream.loadFileToStream(inputFile);
        ArrayList<Book> booksCatalog = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(inputFile);
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
        booksCatalog.forEach(bk -> {
            System.out.println("Содержание книги: " + bk);
            System.out.println("Название книги: " + bk.getTitle());
            System.out.println("Наличие книги: " + (bk.getBusy() ? "Нет" : "Да"));
        });

        while (System.currentTimeMillis() - START_TIME < workTime)
            for (int i = 0; i < (booksCatalog).size(); i++) {
                final int num = 0;
                num++;

                Runnable task = () -> {
                    System.out.println("Scheduling new thread");
                };

                printTask("T" + num);
                scheduler.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.MILLISECONDS);
/*                scheduler.scheduleWithFixedDelay(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, initialDelay, period, TimeUnit.MILLISECONDS);*/

                LibraryClientThread Thread = new LibraryClientThread();
                Thread.setName("Thread #" + i);
                Thread.start();
                final Long rndNumber = 0L;
                booksCatalog.forEach(bk -> {
                    if (!bk.getBusy()) {
                        System.out.println("Название книги: " + bk.getTitle());
                        System.out.println();
                        System.out.println("Наличие книги: " + (bk.getBusy() ? "Нет" : "Да"));
                        Random rnd = new Random();
                        rndNumber = (long) minRange + rnd.nextInt(maxRange - minRange + 1);
                        bk.waitAndSupply(1, rndNumber);
                        try {
                            bk.getBook(1);
                            Thread.sleep(rndNumber);
                            System.out.println("Возврат книги: " + bk.getTitle());
                            System.out.println();
                            bk.putBook(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Выдача книги: " + bk.getTitle());
                        System.out.println();
                        bk.setBusy(true);

                        System.exit(0);

                    }
                });
//                Thread.sleep(15000);
                scheduler.shutdown();
                scheduler.awaitTermination(rndNumber, TimeUnit.SECONDS);
        }
        scheduler.shutdownNow();
        final int[] isFree = {0};
/*        for (int i = 0; i < booksCatalog.size(); i++) {
            if (booksCatalog.getBusy()) {
                isFree[0]++;
            }
        }*/
        booksCatalog.forEach(bk -> {
            if (!bk.getBusy()) {
                isFree[0]++;
            }
        });

        System.out.println("Число запущенных потоков: " + ThreadStatus.getStatus());
        System.out.println();
        System.out.println("Количество книг в каталоге: " + isFree[0]);
        System.out.println();
    }

    private static Runnable printTask(String prefix) {
        return () -> System.out.println(prefix + ": " + (System.currentTimeMillis() - START_TIME));
    }

}
