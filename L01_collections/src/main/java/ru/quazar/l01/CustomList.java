package ru.quazar.l01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Number> {

    private List<T> list = new ArrayList<>();

    public CustomList() {}

    public  void add(T t) {
        list.add(t);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> newList) {
        this.list = newList;
    }

    public void removeElement(T t) {
        list.remove(t);
    }

}

class MinimumClass<T extends Comparable<T>> {
    T minElement(CustomList myList) {
        return (T) Collections.min(myList.getList());
    }
}

class MaximumClass<T extends Comparable<T>> {
    T maxElement(CustomList myList) {
        return (T) Collections.max(myList.getList());
    }
}
