package ru.quazar.l04springboot.repository;

import ru.quazar.l04springboot.model.CustomList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for making repository of CustomList with parameter T. This parameter extends from class Number.
 *
 * @version $Id: CustomListRepository.java,v 1.0 2019-08-19 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Repository
public interface CustomListRepository extends JpaRepository<CustomList, Integer> {
}
