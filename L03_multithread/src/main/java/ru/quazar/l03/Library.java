package ru.quazar.l03;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;-io.src.main.java.ru.quazar.l02.FileGetter;

public class Library {

    public static void main(String[] args) {
        String loadFilePath = "";
        Timer timer = new Timer();
        TimerTask task = new TimerTask();

        ArrayList<Book> booksCatalog = new ArrayList<>();

        FileGetter fileGetter = new FileGetter();

        if (args.length == 0) {
            loadFilePath = "";
        } else {
            loadFilePath = args[1];
        }

        File inputFile = fileGetter.getFileWithConditions(args[0], loadFilePath, inFileName);

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


