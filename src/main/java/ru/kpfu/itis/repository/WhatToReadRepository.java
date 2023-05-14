package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.BookRaiting;

import java.util.List;
@Repository
public interface WhatToReadRepository  extends JpaRepository<BookRaiting, Integer> {

    @Query(value = "select * from books_raiting order by mark desc ", nativeQuery = true)
    List<BookRaiting> getAll();
}