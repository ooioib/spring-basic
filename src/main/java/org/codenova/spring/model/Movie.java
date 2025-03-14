package org.codenova.spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class Movie {

    private int id;
    private String title;
    private String description;
    private String genre;
    private LocalDate releaseDate;
}