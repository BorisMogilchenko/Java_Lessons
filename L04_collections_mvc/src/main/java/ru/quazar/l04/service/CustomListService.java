package main.java.ru.quazar.l04.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import main.java.ru.quazar.l04.model.CustomList;
import main.java.ru.quazar.l04.repository.CustomListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Make generic class CustomList with parameter T. This parameter extends from class Number.
 * This class CustomList must have field ArrayList<T>.
 * This class CustomList must have method "add" taking parameter type T.
 *
 * @version $Id: FileToStream.java,v 1.0 2019-08-19 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
@NoArgsConstructor
@Service
class CustomListService<T extends Number> {
    @Autowired
    private BookRepository repository;

    public List<CustomList> getLists() {
        return repository.findAll();
    }

    public CustomList createList(CustomList list) {
        return repository.save(list.add(t);
    }

    public CustomList updateList(Integer integer, CustomList list) {
        CustomList savedList = repository.findById(integer).get();
        savedList.setList(list.getList());
        return repository.save(savedList);
    }

    public CustomList getList(Integer integer) {
        return repository.findById(integer).get();
    }

    public void deleteAllLists() {
        repository.deleteAll();
    }

    public void deleteList(Integer integer) {
        repository.deleteById(integer);
    }
}
