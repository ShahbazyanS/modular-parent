package com.example.rest.endpoint;


import com.example.common.model.Book;
import com.example.common.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        if (book.getId() > 0) {
            throw new RuntimeException("Id must be 0");
        }
        return bookService.save(book);
    }

    @PutMapping("/books/{id}")
    public Book update(@RequestBody Book book, @PathVariable("id") int id) {
        Book bookById = bookService.findById(id);
        bookById.setTitle(book.getTitle());
        bookById.setDescription(book.getDescription());
        bookById.setPrice(book.getPrice());
        bookById.setAuthorName(book.getAuthorName());
        return bookService.save(bookById);

    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable("id") int id) {
        bookService.delete(id);
    }
}
