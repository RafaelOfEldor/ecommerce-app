package com.example.factory.controller;

import com.example.factory.dtos.AddReviewDTO;
import com.example.factory.dtos.PurchaseItemDTO;
import com.example.factory.model.Order;
import com.example.factory.model.Review;
import com.example.factory.service.ItemService;
import com.example.factory.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewsController {




    private ItemService itemService;
    private ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService, ItemService itemService) {
        this.itemService = itemService;
        this.reviewsService = reviewsService;
    }

    @GetMapping
    public List<Review> getReviews() {
        return reviewsService.getReviews();
    }

    @PostMapping("/addreview")
    public ResponseEntity<Optional<Review>> addReview(@RequestBody AddReviewDTO reviewDTO) {
        return reviewsService.addReview(reviewDTO);
    }

    @GetMapping("/page/{pageNumber}")
    public List<Review> getReviewsByPage(@PathVariable int pageNumber) {
        return reviewsService.getReviewsPageable(pageNumber);
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewsService.getReviewById(id);
    }


}
