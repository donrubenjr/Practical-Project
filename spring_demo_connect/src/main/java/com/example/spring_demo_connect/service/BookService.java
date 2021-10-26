package com.example.spring_demo_connect.service;

import com.example.spring_demo_connect.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> retrieveListOfBooks();
    public Book retrieveBookById(int id);
    public String addBook(Book book);
    public String updateBook(Book book);
    public String deleteBook(int id);
}
