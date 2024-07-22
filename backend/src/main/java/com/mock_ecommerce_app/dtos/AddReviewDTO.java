package com.mock_ecommerce_app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddReviewDTO {
    private String reviewComment;
    private Long itemId;

    private Integer reviewRating;

    private Long userId;

    private String reviewAuthor;

    private String reviewPublishDate;

}
