package com.malex.webapp.model;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String author;
    private String title;
    private Double price;
}