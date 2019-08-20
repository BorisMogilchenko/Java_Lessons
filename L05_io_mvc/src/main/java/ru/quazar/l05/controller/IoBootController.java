package ru.quazar.l04.controller;

import main.java.ru.quazar.l04.model.Book;
import main.java.ru.quazar.l04.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IoBootController {

    @Autowired
    private CustomListService listService;

    @GetMapping("/lists")
    List<list> getList() {
        return CustomListService.getLists();
    }

    @PostMapping("/lists")
    CustomList createList(@RequestBody CustomList list) {
        return CustomListService.createList(list);
    }

    @PutMapping("lists/{integer}")
    CustomList updateList(@RequestBody CustomList list, @PathVariable Integer integer) {
        return CustomListService.updateList(integer, list);
    }

    @GetMapping("/lists/{integer}")
    CustomList getList(@PathVariable Integer integer) {
        return CustomListService.getList(integer);
    }

    @DeleteMapping("/lists")
    void deleteAllLists() {
        CustomListService.deleteAllLists();
    }

    @DeleteMapping("/lists/{integer}")
    void deleteList(@PathVariable Integer integer) {
        CustomListService.deleteList(integer);
    }
}
