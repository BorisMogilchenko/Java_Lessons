package ru.quazar.l03;

import java.util.ArrayList;

public class Book<String> extends ArrayList {
    private String title;
    private Boolean isBusy;
    private int quantity;

    public Book(String title, Boolean isBusy) {
        this.title = title;
        this.isBusy = isBusy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getBusy() {
        return isBusy;
    }

    public void setBusy(Boolean busy) {
        isBusy = busy;
    }

    public int getQuantity() {
        return quantity;
    }

    synchronized void getBook(int amount) {
        checkAmountNotNegative(amount);
        quantity -= amount;
        notifyAll();
    }

    synchronized void putBook(int amount) {
        checkAmountNotNegative(amount);
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount of books");
        }
        quantity += amount;
    }

    void waitAndSupply(int amount, long rnd) {
        checkAmountNotNegative(amount);
        while (quantity < amount) {
            try {
                wait(rnd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        quantity -= amount;
    }

    private void checkAmountNotNegative(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount of books");
        }
    }
}
