package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.KidsBook;

import java.util.List;
@Repository
public interface KidsBookRepository  extends JpaRepository<KidsBook, Integer> {

    @Query(value = "select * from kids_books", nativeQuery = true)
    List<KidsBook> getAll();
}