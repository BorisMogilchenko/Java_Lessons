package ru.quazar.l03;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@Data
//@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LibraryClientThread extends Thread {
    private static final int minRange = 1000;
    private static final int maxRange = 3000;
    private ArrayList<Book> booksCatalog;

    public LibraryClientThread( ArrayList<Book> booksCatalog) {
        this.booksCatalog = booksCatalog;
    }

    @Override
    public void run() {
/*        int rndNumber;

        Random rnd = new Random();
        rndNumber = minRange + rnd.nextInt(maxRange - minRange + 1);

        for (int i = 0; i < booksCatalog.size(); i++) {
            System.out.println(Thread.currentThread().getName());
            if (!booksCatalog.get(i).getBusy()) {
                System.out.println("Название книги: " + booksCatalog.get(i).getTitle());
                System.out.println();
                System.out.println("Наличие книги: " + (booksCatalog.get(i).getBusy() ? "Нет" : "Да"));
//                waitAndSupply(1, rndNumber);
                try {
                    System.out.println("Выдача книги: " + booksCatalog.get(i).getTitle());
                    System.out.println();
                    getBook(1, i);
                    booksCatalog.get(i).setBusy(true);
                    sleep(rndNumber);
                    System.out.println("Возврат книги: " + booksCatalog.get(i).getTitle());
                    System.out.println();
                    putBook(1, i);
                    booksCatalog.get(i).setBusy(false);
                    interrupt();
                    break;
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
//                    e.printStackTrace();
                }
            } else interrupt();
            break;
        }*/

        booksCatalog.forEach(bk -> {
/*            if (!bk.getBusy()) {
                System.out.println("Название книги: " + bk.getTitle());
                System.out.println();
                System.out.println("Наличие книги: " + (bk.getBusy() ? "Нет" : "Да"));
                waitAndSupply(1, rndNumber);
                try {
                    System.out.println("Выдача книги: " + bk.getTitle());
                    System.out.println();
                    getBook(1);
                    bk.setBusy(true);
                    sleep(rndNumber);
                    System.out.println("Возврат книги: " + bk.getTitle());
                    System.out.println();
                    putBook(1);
                    bk.setBusy(false);
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
//                    e.printStackTrace();
                }
                System.out.println("Выдача книги: " + bk.getTitle());
                System.out.println();
                bk.setBusy(true);
            }*/
        });
    }

    synchronized void getBook(int amount, int index) {
        checkAmountNotNegative(amount);
        booksCatalog.get(index).setBusy(true);
        notifyAll();
    }

    synchronized void putBook(int amount, int index) {
        checkAmountNotNegative(amount);
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount of books");
        }
        booksCatalog.get(index).setBusy(false);
    }

    void waitAndSupply(int amount, long rnd) {
        checkAmountNotNegative(amount);
//        while (quantity < amount) {
            try {
                wait(rnd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }
//        quantity -= amount;
    }

    private void checkAmountNotNegative(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount of books");
        }
    }
}
