package ru.kpfu.itis.dto;

import lombok.Builder;
import lombok.Data;
import ru.kpfu.itis.model.Review;

@Data
@Builder
public class ReviewResponseDto {

    private Integer id;

    private String author;

    private String description;
    private String name;

    private Integer bookId;

    private Integer mark;

    public static ReviewResponseDto fromEntity(Review review) {
        return ReviewResponseDto.builder()
                .id(review.getId())
                .author(review.getAuthor())
                .description(review.getDescription())
                .name(review.getName())
                .bookId(review.getBook().getId())
                .mark(review.getMark())
                .build();
    }
}