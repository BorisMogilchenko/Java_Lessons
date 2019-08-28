package ru.quazar.l04springboot.service;

import lombok.NoArgsConstructor;

import java.util.Collections;
import ru.quazar.l04springboot.model.CustomList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * param myList Collection ArrayList
 *
 * return Collections.min Minimum value of element collection/
 *
 * @version $Id: MinimumClass.java,v 1.0 2019-08-19 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@NoArgsConstructor
@Service
public class MinimumClass<T extends Comparable<T>> {
    @Autowired     T minElement(CustomList myList) {
        return (T) Collections.min(myList.getList());
    }
}
