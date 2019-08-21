package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Book extends ArrayList {
//    @Getter
//    @Setter
//    @EqualsAndHashCode(callSuper = false);
//    private String title;
    String title;
//    @Getter
//    @Setter
//    @EqualsAndHashCode(callSuper = false);
//    private boolean isBusy;
    Boolean isBusy;
//    @Getter
//    @Setter
//    @EqualsAndHashCode(callSuper = false);
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

    synchronized void getBook(int amount) {
        checkAmountNotNegative(amount);
        quantity += amount;
        notifyAll();
    }

    synchronized void putBook(int amount) {
        checkAmountNotNegative(amount);
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount of books");
        }
        quantity -= amount;
    }

    void waitAndSupply(int amount) {
        checkAmountNotNegative(amount);
        while (quantity < amount) {
            try {
                wait();
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
