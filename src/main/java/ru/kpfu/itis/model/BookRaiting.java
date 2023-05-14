package ru.kpfu.itis.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "booksRaiting")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookRaiting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int numberOfReviews;
    @Column(nullable = false)
    private String mark;
    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
