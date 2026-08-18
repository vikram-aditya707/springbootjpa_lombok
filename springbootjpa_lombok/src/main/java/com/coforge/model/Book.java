package com.coforge.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private long isbn;

    private String bname;

    private float cost;

    @OneToOne(cascade = CascadeType.ALL)
    private Author author;

    @OneToMany(mappedBy = "book",
               cascade = CascadeType.ALL,
               fetch = FetchType.EAGER)
    private Set<Publisher> publishers;

}