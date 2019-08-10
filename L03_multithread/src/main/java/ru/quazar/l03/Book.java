package ru.quazar.l03;

public class Book {
    private String title;
    private Boolean isBusy;

    public Book() {}

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

}
