package ru.kpfu.itis.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "kidsBooks")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class KidsBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}