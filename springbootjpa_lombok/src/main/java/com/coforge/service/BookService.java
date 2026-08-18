package com.coforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.exception.BookException;
import com.coforge.model.Book;
import com.coforge.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> showAllBooks() {

        if (bookRepository.findAll().isEmpty())
            throw new BookException("Book list is empty");

        return bookRepository.findAll();
    }

    public Book updateBook(Book book) {

        if (bookRepository.findById(book.getIsbn()).isEmpty())
            throw new BookException("Book isbn not present");

        return bookRepository.save(book);
    }

    public Book searchByBookId(long id) {

        return bookRepository.findById(id)
                .orElseThrow(() -> new BookException("Book isbn not present"));
    }

    public Book deleteByBookId(long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookException("Book isbn not present"));

        bookRepository.deleteById(id);

        return book;
    }

    // Find by Book Name
    public Book findByBookName(String bname) {

        Book book = bookRepository.findByBname(bname);

        if (book == null)
            throw new BookException("Book not found");

        return book;
    }

    // JPQL Query
    public Book searchBookByName(String bname) {

        Book book = bookRepository.searchByBname(bname);

        if (book == null)
            throw new BookException("Book not found");

        return book;
    }

    // Derived Query
    public Book findByBookNameAndCost(String bname, double cost) {

        Book book = bookRepository.findByBnameAndCost(bname, cost);

        if (book == null)
            throw new BookException("Book not found");

        return book;
    }

    // Find by Cost
    public Book findByCost(double cost) {

        Book book = bookRepository.findByCost(cost);

        if (book == null)
            throw new BookException("Book not found");

        return book;
    }

}