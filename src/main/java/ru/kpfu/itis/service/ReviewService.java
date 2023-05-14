package ru.kpfu.itis.service;

import ru.kpfu.itis.dto.ReviewResponseDto;

import java.util.List;

public interface ReviewService {
    List<ReviewResponseDto> findAllByAuthor(String author);

    List<ReviewResponseDto> findAllByBookName(String name);

    void deleteReviewById(Integer id);

    void saveReview(String author, String description, String name, Integer book_id, Integer mark);
    String getNameById(Integer id);
}
