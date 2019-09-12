package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Library {
    private static final int workTime = 30000;
    private static long START_TIME;

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
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
        ArrayList< Book > booksCatalog = new ArrayList<>();
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
            System.out.println("Название книги: " + bk.getTitle());
            System.out.println("Наличие книги: " + (bk.getBusy() ? "Нет" : "Да"));
        });

        while (System.currentTimeMillis() - START_TIME < workTime) {
            for (int i = 0; i < (booksCatalog).size(); i++) {

/*                Runnable task = () -> {
                    System.out.println(Thread.currentThread().getName());
                };
                for (int j = 0; j < 5; j++) {
                    Future result = scheduler.submit(task);
                    System.out.println(result.get());
                }*/

/*                Runnable MyTimerTask {
                    public void run() {
                    }
                }*/
//                scheduler.scheduleAtFixedRate(new MyTimerTask(), initialDelay, period, TimeUnit.MILLISECONDS);
                scheduler.scheduleAtFixedRate(() -> System.out.println("Scheduling: " + Thread.currentThread().getName()), initialDelay, period, TimeUnit.MILLISECONDS);
                LibraryClientThread LibraryClientThread = new LibraryClientThread("Thread #" + i++, booksCatalog);
                LibraryClientThread.start();

/*                scheduler.scheduleWithFixedDelay(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, initialDelay, period, TimeUnit.MILLISECONDS);*/

/*                booksCatalog.forEach(bk -> {
                    if (!bk.getBusy()) {
                        System.out.println("Название книги: " + bk.getTitle());
                        System.out.println();
                        System.out.println("Наличие книги: " + (bk.getBusy() ? "Нет" : "Да"));
                        Thread.waitAndSupply(1);
//                        try {
                            Thread.getBook(1);
                            System.out.println("Возврат книги: " + bk.getTitle());
                            System.out.println();
                            Thread.putBook(1);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        System.out.println("Выдача книги: " + bk.getTitle());
                        System.out.println();
                        bk.setBusy(true);

//                        System.exit(0);

                    }
                });*/
/*                try {
                    scheduler.shutdown();
                    scheduler.awaitTermination(workTime, TimeUnit.SECONDS);
                } catch (InterruptedException ex) {
                    System.out.println("All threads are shutdown!!!");
                }*/

//                scheduler.shutdownNow();
                int isFree = 0;
        for (int k = 0; k < booksCatalog.size(); k++) {
            if (booksCatalog.get(k).getBusy()) {
                isFree++;
            }
        }
/*                final int[] isFree = {0};
                booksCatalog.forEach(bk -> {
                    if (!bk.getBusy()) {
                        isFree[0]++;
                    }
                });*/

                System.out.println("Число запущенных потоков: " + ThreadStatus.getStatus());
                System.out.println();
                System.out.println("Количество книг в каталоге: " + isFree);
                System.out.println();
            }
        }
    }
}
