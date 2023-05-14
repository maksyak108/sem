package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Book;

import java.util.List;
@Repository
public interface BooksRepository  extends JpaRepository<Book, Integer> {

    @Query(value = "select * from books", nativeQuery = true)
    List<Book> getAll();

    @Query(value = "select * from books b where b.genre like ?1", nativeQuery = true)
    List<Book> findBooksByGenre(String genre);

    @Query(value = "select * from books b where b.name like ?1", nativeQuery = true)
    Book findBookByName(String name);
}