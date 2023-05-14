package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Review;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface ReviewRepository  extends JpaRepository<Review, Integer> {

    @Query(value = "select * from reviews r where r.author like ?1", nativeQuery = true)
    List<Review> findAllByAuthor(String author);

    @Query(value = "select * from reviews r where r.name like ?1", nativeQuery = true)
    List<Review> findAllByBookName(String name);
    @Query(value = "delete from reviews where id = ?1", nativeQuery = true)
    void deleteReviewById(Integer id);
    @Query(value = "select name from reviews where id = ?1", nativeQuery = true)
    String getNameById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "INSERT into reviews(author, description, name, book_id, mark) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void saveReview(String author, String description, String name, Integer book_id, Integer mark);
}
