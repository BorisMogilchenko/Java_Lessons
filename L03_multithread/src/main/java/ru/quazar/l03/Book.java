package ru.quazar.l03;

import java.util.ArrayList;

public class Book extends ArrayList {
    private String title;
    private Boolean isBusy;
//    private int quantity;
//    private List<T> list = new ArrayList<>();

//    public Book() {}

    public Book(String title, Boolean isBusy) {
        this.title = title;
        this.isBusy = isBusy;
    }

/*    public  void addList(T t) {
        list.add(t);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> newList) {
        this.list = newList;
    }*/

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

//    public int getQuantity() {
//        return quantity;
//    }

}
