package ru.quazar.l01;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
class CustomList<T extends Number> {

    private List<T> list = new ArrayList<>();

    void add(T t) {
        list.add(t);
    }

    void removeElement(T t) {
        list.remove(t);
    }

    @Override
    public String toString() {
        return "CustomList{" +
                "list=" + list +
                '}';
    }
}
