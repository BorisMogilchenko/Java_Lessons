package ru.quazar.l01;

import lombok.NoArgsConstructor;
import java.util.Collections;

@NoArgsConstructor
class MinimumClass<T extends Comparable<T>> {
    T minElement(CustomList myList) {
        return (T) Collections.min(myList.getList());
    }
}
