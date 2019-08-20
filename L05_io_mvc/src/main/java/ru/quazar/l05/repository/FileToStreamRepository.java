package main.java.ru.quazar.l04.repository;

import main.java.ru.quazar.l04.model.CustomList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for making repozitory of CustomList with parameter T. This parameter extends from class Number.
 *
 * @version $Id: FileToStream.java,v 1.0 2019-08-19 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Repository
public interface FileToStreamRepository extends JpaRepository<CustomList, Integer> {
}
