package ru.quazar.l01;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Make generic class CustomList with parameter T. This parameter extends from class Number.
 * This class CustomList must have field ArrayList<T>.
 * This class CustomList must have method "add" taking parameter type T.
 *
 * @version $Id: FileToStream.java,v 1.0 2019-08-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

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

}
