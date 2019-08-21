package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Library {
    private static final int minRange = 1000;
    private static final int maxRange = 3000;

    public static void main(String[] args) {
        String inFileName = "";
        int initialDelay = 0;
        int period = 250;
        long startTime=System.currentTimeMillis();

        TimerTask timerTask = new MyTimerTask();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
        System.out.println("TimerTask начал выполнение");
//        timer.scheduleAtFixedRate();

        ArrayList<Book> booksCatalog = new ArrayList<>();
//        ExecutorService executor = new Executors.newFixedThreadPool(1);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(booksCatalog.size());

        GettingFile gettingFile = new GettingFile();

        if (args.length == 0) {
            inFileName = "";
        } else {
            inFileName = args[0];
        }

        try {
            File inputFile = gettingFile.getFileWithConditions(inFileName);
            FileToBufStream.loadFileToStream(inputFile, booksCatalog);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (Book bk : booksCatalog) {
            System.out.println("Название книги: " + bk.getTitle());
            System.out.println("Наличие книги: " + (bk.getBusy() ? "Нет" : "Да"));
        }

/*        for (int i = 0; i < (booksCatalog.size()); i++) {
            System.out.println("Название книги: " + booksCatalog.getTitle());
            System.out.println("Наличие книги: " + (booksCatalog.getBusy() ? "Нет" : "Да"));
        }*/

        Runnable task = () -> System.out.println("Schedulling: " + System.nanoTime());
        scheduler.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.MILLISECONDS);

        int num = 0;
        for (int i = 0; i < (booksCatalog).size(); i++) {
            num++;
            LibraryClientThread libraryClientThread = new LibraryClientThread();
            libraryClientThread.setName("Thread #"+num);
            libraryClientThread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            } catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        }
    }
}


