package ru.quazar.l04springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.quazar.l04springboot.model.CustomList;
import ru.quazar.l04springboot.service.CustomListService;

import java.util.List;

@RestController
public class CustomListController {

    @Autowired
    private CustomListService listService;

    @GetMapping("/lists")
    List<CustomList> getList() {
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
