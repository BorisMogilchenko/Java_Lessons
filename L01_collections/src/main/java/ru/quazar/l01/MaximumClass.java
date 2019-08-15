package ru.quazar.l01;

import lombok.NoArgsConstructor;

import java.util.Collections;

@NoArgsConstructor
class MaximumClass<T extends Comparable<T>> {
    T maxElement(CustomList myList) {
        return (T) Collections.max(myList.getList());
    }
}
