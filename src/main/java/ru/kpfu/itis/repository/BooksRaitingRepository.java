package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.BookRaiting;

import javax.transaction.Transactional;

@Repository
public interface BooksRaitingRepository  extends JpaRepository<BookRaiting, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE books_raiting SET number_of_reviews = ?1, mark = ?2 WHERE name = ?3", nativeQuery = true)
    void updateRaiting(Integer number_of_reviews, Double mark, String name);


    @Query(value = "select number_of_reviews from books_raiting where name = ?1", nativeQuery = true)
    Integer getNumberByName(String name);

    @Query(value = "select mark from books_raiting where name = ?1", nativeQuery = true)
    Double getMarkByName(String name);
}