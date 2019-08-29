package ru.quazar.l04springboot.service;

import lombok.NoArgsConstructor;
import java.util.Collections;
import ru.quazar.l04springboot.model.CustomList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * param myList Collection ArrayList
 *
 * return Collections.max Maximum value of element collection/
 *
 * @version $Id: MaximumClass.java,v 1.0 2019-08-27 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@NoArgsConstructor
@Service
/**
 * Find element with maximum value
 *
 * @param myList Collection of integer elements
 * @return Element with maximum value
 */
public class MaximumClass<T extends Comparable<T>> {
    @Autowired
    public T maxElement(CustomList myList) {
        return (T) Collections.max(myList.getList());
    }
}
