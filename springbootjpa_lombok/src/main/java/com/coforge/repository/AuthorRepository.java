package com.coforge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.coforge.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

//    Author findByAuthorNameString(String authorNameString);
//
//    @Query("select a from Author a where a.authorNameString=?1")
//    Author searchByAuthorName(String authorNameString);
//
//    Author findByAuthorAge(int authorAge);
//
//    Author findByAuthorNameStringAndAuthorAge(String authorNameString,
//                                              int authorAge);

}
