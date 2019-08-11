package ru.quazar.l01;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
class MinimumClass<T extends Comparable<T>> {
    T minElement(CustomList myList) {
        return (T) Collections.min(myList.getList());
    }
}
