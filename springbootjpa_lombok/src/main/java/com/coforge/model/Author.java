package com.coforge.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue
    private long authorId;

    private String authorNameString;

    private int authorAge;

    @OneToOne(mappedBy = "author",
              cascade = CascadeType.ALL,
              fetch = FetchType.EAGER)
    private Book book;

}