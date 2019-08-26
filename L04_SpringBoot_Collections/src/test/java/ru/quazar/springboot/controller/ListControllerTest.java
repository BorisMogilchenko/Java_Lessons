package ru.quazar.springboot.controller;

import net.arjah.lessontestboot.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListControllerTest {

    @Autowired
    private ListService listService;

    @GetMapping("/books")
    List<list> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/books")
    Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("books/{id}")
    Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        return bookService.updateBook(id, book);
    }

    @GetMapping("/books/{id}")
    Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("/books")
    void deleteAllBooks() {
        bookService.deleteAllBooks();
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
