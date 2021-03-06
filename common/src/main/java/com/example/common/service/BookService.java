package com.example.common.service;


import com.example.common.exception.ResourceNotFoundException;
import com.example.common.model.Book;
import com.example.common.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book save(Book book){
      return bookRepository.save(book);
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(int id){
        Book bookFromDB = bookRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Book does not exist"));
        return bookFromDB;
    }
    public void delete(int id){
        bookRepository.delete(bookRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Book does not exist")));
    }
}
