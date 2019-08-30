package ru.quazar.l04springboot.service;

import lombok.Data;
import lombok.NoArgsConstructor;

import ru.quazar.l04springboot.model.CustomList;
import ru.quazar.l04springboot.repository.CustomListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Make generic class CustomList with parameter T. This parameter extends from class Number.
 * This class CustomList must have field ArrayList<T>.
 * This class CustomList must have method "add" taking parameter type T.
 *
 * @version $Id: CustomListService.java,v 1.0 2019-08-19 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
@NoArgsConstructor
@Service
public class CustomListService {
    @Autowired
    private static CustomListRepository repository;

    /**
     * Get list all elements from repository
     *
     * @param list Collection of Integer elements
     * @return List all elements from repository
     */
    public static List<CustomList> getLists() {
        return repository.findAll();
    }

    /**
     * Create list integer elements with saving into repository
     *
     * @param integer Integer elements of list collection
     * @param list Collection list by type CustomList
     * @return Collection list with saving into repository
     */
    public static CustomList<Integer> createList(CustomList list) {
        return repository.save(list);
    }

    /**
     * Update value of element by list collection with saving into repository
     *
     * @param integer Index of element in the list
     * @param list Collection of integer elements
     * @return Updated list with saving into repository
     */
    public static CustomList updateList(Integer integer, CustomList list) {
        CustomList savedList = repository.findById(integer).get();
        savedList.setList(list.getList());
        return repository.save(savedList);
    }

    /**
     * Get List by Id from repository
     *
     * @param integer Id element of List
     * @return List by Id from repository
     */
    public static CustomList getList(Integer integer) {
        return repository.findById(integer).get();
    }

    /**
     * Delete all elements of collection in repository
     */
    public static void deleteAllLists() {
        repository.deleteAll();
    }

    /**
     * Delete element of List by Id
     *
     * @param integer Id element of List
     */
    public static void deleteList(Integer integer) {
        repository.deleteById(integer);
    }
}
