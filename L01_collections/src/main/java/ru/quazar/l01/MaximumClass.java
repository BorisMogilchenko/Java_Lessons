package ru.quazar.l01;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
class MaximumClass<T extends Comparable<T>> {
    T maxElement(CustomList myList) {
        return (T) Collections.max(myList.getList());
    }
}
