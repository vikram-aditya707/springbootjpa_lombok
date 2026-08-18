package com.coforge.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Library {

    private int id;
    private String name;
    private LocalDate startDate;

    @PostConstruct
    public void init() {
        id = 878687;
        name = "Kids Library";
        startDate = LocalDate.of(2022, 11, 22);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}