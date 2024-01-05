package com.example.factory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq_gen")
    @SequenceGenerator(name = "review_seq_gen", sequenceName = "review_seq", allocationSize = 1)
    @Column(name = "review_id")
    private Long reviewId = 0L;

    @Column(name= "review_comment")
    private String reviewComment;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name= "review_rating")
    private int reviewRating;

    @Column(name= "review_author")
    private String reviewAuthor;
}
