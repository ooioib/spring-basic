package org.codenova.spring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class Drama {

    private int id;
    private String title;
    private String broadcaster;
    private String mainActor;
    private LocalDate releaseDate;
}