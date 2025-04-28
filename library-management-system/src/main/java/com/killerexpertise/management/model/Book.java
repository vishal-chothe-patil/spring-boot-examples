package com.killerexpertise.management.model;

import lombok.Data;

@Data
public class Book {

    private int bid;
    private String title;
    private String author;
    private String genre;
    private int publishedYear;
}
