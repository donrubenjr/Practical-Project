package com.example.spring_demo_connect.service;

import com.example.spring_demo_connect.model.Book;
import com.example.spring_demo_connect.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional
    public List<Book> retrieveListOfBooks() {
//        List<Book> books = (List<Book>) bookRepository.findAll();
//        return books;

        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book retrieveBookById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    @Transactional
    public String addBook(Book addBook) {
        bookRepository.save(addBook);
        String message = "Saving Failed";
        if (retrieveBookById(addBook.getId()) != null){
            message = "Successfully saved in the database";
        }
        return message;
    }

    @Override
    @Transactional
    public String updateBook(Book updateBook) {
        Book book = retrieveBookById(updateBook.getId());
        String message = "Update Failed";
        if (book != null){
            book.setTitle(updateBook.getTitle());
            book.setAuthor(updateBook.getAuthor());
            book.setYearPublished(updateBook.getYearPublished());
            bookRepository.save(book);
            message = "Record Updated";
        }
        return message;
    }

    @Override
    @Transactional
    public String deleteBook(int id) {
        String message = "Delete Failed";
        if (retrieveBookById(id) != null){
            bookRepository.deleteById(id);

            if (retrieveBookById(id) == null){
                message = "Delete Successfully";
            }
        }
        return message;
    }
}
