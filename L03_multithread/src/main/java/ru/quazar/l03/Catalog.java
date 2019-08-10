package ru.quazar.l03;

public class Catalog {
    private int quantity;

    public Catalog() {
        this(0);
    }

    public Catalog(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public synchronized void inputCatalog(int amount) {
        checkAmountNotNegative(amount);
        quantity += amount;
        notifyAll();
    }

    public synchronized void outputCatalog(int amount) {
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
