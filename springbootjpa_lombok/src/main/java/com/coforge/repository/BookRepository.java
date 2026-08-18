package com.coforge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coforge.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByBname(String bname);

    @Query("select b from Book b where b.bname=?1")
    Book searchByBname(String bname);

    Book findByBnameAndCost(String bname, double cost);

    Book findByCost(double cost);

}