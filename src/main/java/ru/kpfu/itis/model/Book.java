package ru.kpfu.itis.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String description;

    @OneToOne(mappedBy = "book")
    private BookRaiting bookRaiting;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews = new ArrayList<>();
}
