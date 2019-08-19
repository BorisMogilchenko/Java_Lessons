package main.java.ru.quazar.l04.service;

import lombok.NoArgsConstructor;
import java.util.Collections;
import net.arjah.lessontestboot.model.Book;
import net.arjah.lessontestboot.repository.BookRepository;
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
class MaximumClassService<T extends Comparable<T>> {
    @Autowired     T maxElement(CustomList myList) {
        return (T) Collections.max(myList.getList());
    }
}
