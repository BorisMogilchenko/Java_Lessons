package ru.quazar.l04springboot.service;

import lombok.NoArgsConstructor;
import java.util.Collections;
import ru.quazar.l04springboot.model.CustomList;
import ru.quazar.l04springboot.repository.CustomListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * param myList Collection ArrayList
 *
 * return Collections.max Maximum value of element collection/
 *
 * @version $Id: StreamToFile.java,v 1.0 2019-08-19 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@NoArgsConstructor
@Service
public class MaximumClassService<T extends Comparable<T>> {
    @Autowired     T maxElement(CustomList myList) {
        return (T) Collections.max(myList.getList());
    }
}
