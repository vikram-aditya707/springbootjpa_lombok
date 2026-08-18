package com.coforge.model;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Publisher {

    @Id
    @GeneratedValue
    private UUID publisherIdUuid;

    private String publisherNameString;

    private String publisherLocationString;

    @ManyToOne(cascade = CascadeType.ALL,
               fetch = FetchType.EAGER)
    private Book book;

}