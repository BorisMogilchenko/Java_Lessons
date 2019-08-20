package ru.quazar.l05.controller;

import main.java.ru.quazar.l04.model.Book;
import main.java.ru.quazar.l04.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * IoStreamController witch manages models, services, repositories.
 *
 * @version $Id: IoStreamController.java,v 1.0 2019-08-20 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@RestController
public class IoStreamController {

    @Autowired
    private FileGetterService fileGetterService;
    private FileToStreamServise fileToStreamServise;
    private StreamToFileService streamToFileService;

    @GetMapping("/streams")
    List<list> getList() {
        return CustomListService.getLists();
    }

    @PostMapping("/streams")
    CustomList createList(@RequestBody CustomList list) {
        return CustomListService.createList(list);
    }

    @PutMapping("streams/{string}")
    CustomList updateList(@RequestBody CustomList list, @PathVariable Integer integer) {
        return CustomListService.updateList(integer, list);
    }

    @GetMapping("/streams/{string}")
    CustomList getList(@PathVariable Integer integer) {
        return CustomListService.getList(integer);
    }

    @DeleteMapping("/streams")
    void deleteAllLists() {
        CustomListService.deleteAllLists();
    }

    @DeleteMapping("/streams/{string}")
    void deleteList(@PathVariable Integer integer) {
        CustomListService.deleteList(integer);
    }
}
