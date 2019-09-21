package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

@Data
@AllArgsConstructor
public class Library {
    private static final int workTime = 30000;
    private static long START_TIME;

    public static void main(String[] args) {
        START_TIME = System.currentTimeMillis();
        String inFileName = "";
        int initialDelay = 2000;
        int period = 2500;

        System.out.println("TimerTask начал выполнение");

        GettingFile gettingFile = new GettingFile();

        if (args.length == 0) {
            inFileName = "";
        } else {
            inFileName = args[0];
        }

        File inputFile = gettingFile.getFileWithConditions(inFileName);
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

        int isFreeBook = 0;
        for (int z = 0; z < booksCatalog.size(); z++) {
            if (!booksCatalog.get(z).getBusy()) {
                isFreeBook++;
            }
        }
        System.out.println("Количество книг в каталоге: " + isFreeBook);

        while (System.currentTimeMillis() - START_TIME < workTime) {
/*            final Runnable task = () -> {
//                System.out.println("New thread had started");
//                new LibraryClientThread(booksCatalog).start();
                List< Future<String> > futurs = null;
                try {
                    futurs = scheduler.invokeAll(
                            Arrays.asList(new LibraryClient("Thread 1", booksCatalog),new LibraryClient("Thread 2", booksCatalog),
                                    new LibraryClient("Thread 3", booksCatalog), new LibraryClient("Thread 4", booksCatalog),
                                    new LibraryClient("Thread 5", booksCatalog))
                    );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (Future<String> future : futurs) {
                    try {
                        System.out.println("Result from list LibraryClient " + future.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }

                scheduler.shutdown();
                try {
                    scheduler.awaitTermination(10L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            final ScheduledFuture<?> taskHandler =
                    scheduler.scheduleAtFixedRate(task, initialDelay, period, MILLISECONDS);
            scheduler.schedule(new Runnable() {
                public void run() { taskHandler.cancel(true); }
            }, workTime, SECONDS);

            scheduler.shutdown();
            try {
                scheduler.awaitTermination(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            LibraryClient library = new LibraryClient();
            library.start(booksCatalog);

            for (int i = 0; i < (booksCatalog).size(); i++) {

/*                Runnable task = () -> {
                    List< Future<String> > futurs = null;
                    try {
                        futurs = scheduler.invokeAll(
                                Arrays.asList(new LibraryClientThread("Thread 1"),new LibraryClientThread("Thread 2"),
                                        new LibraryClientThread("Thread 3"), new LibraryClientThread("Thread 4"),
                                        new LibraryClientThread("Thread 5"))
                        );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    for (Future<String> future : futurs) {
                        try {
                            System.out.println("Result from list LibraryClient " + future.get());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }

                    scheduler.shutdown();
                    try {
                        scheduler.awaitTermination(10L, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//                    System.out.println(Thread.currentThread().getName());
//                    LibraryClientThread LibraryClientThread = new LibraryClientThread(booksCatalog);
//                    LibraryClientThread.start();
                };*/
/*                for (int j = 0; j < 5; j++) {
                    Future result = scheduler.submit(task);
                    System.out.println(result.get());
                }*/

//                scheduler.scheduleAtFixedRate(new MyTimerTask(), initialDelay, period, TimeUnit.MILLISECONDS);
//                scheduler.scheduleAtFixedRate(new LibraryClientThread(booksCatalog), initialDelay, period, TimeUnit.MILLISECONDS);

/*                try {
                    scheduler.shutdown();
                    scheduler.awaitTermination(workTime, TimeUnit.SECONDS);
                } catch (InterruptedException ex) {
                    System.out.println("All threads are shutdown!!!");
                }*/

//                scheduler.shutdownNow();
/*                final int[] isFree = {0};
                booksCatalog.forEach(bk -> {
                    if (!bk.getBusy()) {
                        isFree[0]++;
                    }
                });*/
            }

/*            int isFree = 0;
            for (int k = 0; k < booksCatalog.size(); k++) {
                if (!booksCatalog.get(k).getBusy()) {
                    isFree++;
                }
           }*/

            library.stop();

/*            System.out.println("Число запущенных потоков: " + ThreadStatus.getStatus());
            System.out.println();
            System.out.println("Количество книг в каталоге: " + isFree);
            System.out.println();*/
        }
    }

    public static class LibraryClient implements Callable<String>, Runnable {
        private final int minRange = 1000;
        private final int maxRange = 3000;
        private String name;
//        private ScheduledExecutorService scheduler;
        long rndNumber;
//        private ArrayList<Book> booksCatalog;
        private ScheduledFuture<?> findBook;

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        @Override
        public void run() {
            System.out.println("New thread!!!");
        }

        public void start(ArrayList<Book> booksCatalog) {
//            this.booksCatalog = booksCatalog;
            findBook = scheduler.scheduleAtFixedRate(new LibraryClientThread(booksCatalog), 0, 250, TimeUnit.MILLISECONDS);
        }

        public void stop() {
            findBook.cancel(true);
            scheduler.shutdownNow();
        }

        public String call() throws InterruptedException {
            Random rnd = new Random();
            rndNumber = (long) (minRange + rnd.nextInt(maxRange - minRange + 1));

            for (int i = 1; i < 10; i++) {
                this.name = "Thread#" + i;
                System.out.println(name + " started, going to sleep for " + rndNumber);
/*                if (!booksCatalog.get(i).getBusy()) {
                    System.out.println("Название книги: " + booksCatalog.get(i).getTitle());
                    System.out.println();
                    System.out.println("Наличие книги: " + (booksCatalog.get(i).getBusy() ? "Нет" : "Да"));
//                    booksCatalog.get(i).waitAndSupply(1, rndNumber);
                    try {
                        System.out.println("Выдача книги: " + booksCatalog.get(i).getTitle());
                        System.out.println();
//                        booksCatalog.get(i).getBook(1, i);
                        booksCatalog.get(i).setBusy(true);
                        sleep(rndNumber);
                        System.out.println("Возврат книги: " + booksCatalog.get(i).getTitle());
                        System.out.println();
//                        booksCatalog.putBook(1, i);
                        booksCatalog.get(i).setBusy(false);
//                        Thread.interrupt();
                        break;
                    } catch (InterruptedException e) {
                        System.out.println("Thread has been interrupted");
    //                   e.printStackTrace();
                    }
                } else break;*/
            }

            Thread.sleep(rndNumber);
            System.out.println(name + " finished");
            return name;
        }

    }

    public static class Splash {

        private final ScheduledExecutorService scheduler;
        private ScheduledFuture<?> point6;
        private ScheduledFuture<?> point60;

        public Splash() {
            scheduler = Executors.newSingleThreadScheduledExecutor();
        }

        public void start() {
            point60 = scheduler.scheduleAtFixedRate(new Out(System.out, '|'), 60, 60, TimeUnit.SECONDS);
            point6 = scheduler.scheduleAtFixedRate(new Out(System.out, '*'), 0, 6, TimeUnit.SECONDS);
        }

        public void stop() {
            point6.cancel(true);
            point60.cancel(true);
            scheduler.shutdownNow();
        }

        public static class Out implements Runnable {
            private char ch;
            private PrintStream out;

            public Out(PrintStream out, char ch) {
                this.out = out;
                this.ch = ch;
            }

            public void run() {
                out.print(ch);
            }
        }
    }
}
