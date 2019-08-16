package ru.quazar.l01;

import lombok.NoArgsConstructor;
import java.util.Collections;

/**
 * param myList Collection ArrayList
 *
 * return Collections.min Minimum value of element collection/
 *
 * @version $Id: StreamToFile.java,v 1.0 2019-08-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@NoArgsConstructor
class MinimumClass<T extends Comparable<T>> {
    T minElement(CustomList myList) {
        return (T) Collections.min(myList.getList());
    }
}
