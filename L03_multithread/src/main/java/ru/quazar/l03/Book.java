package ru.quazar.l03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
class Book {
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private boolean isBusy;
    @Getter
    @Setter
    private int quantity;

    private List list = new ArrayList<>();

    public void addBook(ArrayList appendBook) {
        list.add(appendBook);
    }

    public synchronized void getBook(int amount) {
        checkAmountNotNegative(amount);
        quantity += amount;
        notifyAll();
    }

    public synchronized void putBook(int amount) {
        checkAmountNotNegative(amount);
        if (amount < 0) {
            throw new IllegalArgumentException("Negative amount of books");
        }
        quantity -= amount;
    }

    public void waitAndSupply(int amount) {
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
