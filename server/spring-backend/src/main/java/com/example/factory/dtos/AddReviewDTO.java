package com.example.factory.dtos;

import com.example.factory.model.Item;
import com.example.factory.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

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
