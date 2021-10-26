package com.example.spring_demo_connect.controller;

import com.example.spring_demo_connect.model.Book;
import com.example.spring_demo_connect.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books/all")
    public List<Book> getAllBooks(){
        return bookService.retrieveListOfBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.retrieveBookById(id);
    }

    @PostMapping("/books")
    public String addBooks(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/books")
    public String updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable int id){
        return bookService.deleteBook(id);
    }
}
