package com.coforge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coforge.exception.BookException;
import com.coforge.model.Book;
import com.coforge.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody Book book) {

        try {
            return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
        } catch (BookException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book")
    public ResponseEntity<?> showAllBooks() {

        try {
            return new ResponseEntity<>(bookService.showAllBooks(), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/book")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {

        try {
            return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> searchByBookId(@PathVariable long id) {

        try {
            return new ResponseEntity<>(bookService.searchByBookId(id), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteByBookId(@PathVariable long id) {

        try {
            return new ResponseEntity<>(bookService.deleteByBookId(id), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/name/{bname}")
    public ResponseEntity<?> findByBookName(@PathVariable String bname) {

        try {
            return new ResponseEntity<>(bookService.findByBookName(bname), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/search/{bname}")
    public ResponseEntity<?> searchBookByName(@PathVariable String bname) {

        try {
            return new ResponseEntity<>(bookService.searchBookByName(bname), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/{bname}/{cost}")
    public ResponseEntity<?> findByBookNameAndCost(@PathVariable String bname,
                                                   @PathVariable double cost) {

        try {
            return new ResponseEntity<>(bookService.findByBookNameAndCost(bname, cost), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/cost/{cost}")
    public ResponseEntity<?> findByCost(@PathVariable double cost) {

        try {
            return new ResponseEntity<>(bookService.findByCost(cost), HttpStatus.OK);
        } catch (BookException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}