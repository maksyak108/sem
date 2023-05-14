package ru.kpfu.itis.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.ReviewResponseDto;
import ru.kpfu.itis.repository.ReviewRepository;
import ru.kpfu.itis.service.ReviewService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    @Override
    public List<ReviewResponseDto> findAllByAuthor(String author) {
        return reviewRepository.findAllByAuthor(author).stream().map(r -> ReviewResponseDto.builder()
                .id(r.getId())
                .author(r.getAuthor())
                .description(r.getDescription())
                .name(r.getName())
                .bookId(r.getBook().getId())
                .mark(r.getMark())
                .build()
        ).collect(Collectors.toList());
    }

    @Override
    public List<ReviewResponseDto> findAllByBookName(String name) {
        return reviewRepository.findAllByBookName(name).stream().map(r -> ReviewResponseDto.builder()
                .id(r.getId())
                .author(r.getAuthor())
                .description(r.getDescription())
                .name(r.getName())
                .bookId(r.getBook().getId())
                .mark(r.getMark())
                .build()
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteReviewById(Integer id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public String getNameById(Integer id){
        return reviewRepository.getNameById(id);
    }

    @Override
    public void saveReview(String author, String description, String name, Integer book_id, Integer mark){ reviewRepository.saveReview(author, description, name, book_id, mark);}
}
