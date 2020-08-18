package com.example.web.controller;

import com.example.common.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public String allBooks(ModelMap map){
        map.addAttribute("books", bookService.findAll());
        return "books";
    }
}
