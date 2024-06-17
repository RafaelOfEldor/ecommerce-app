package com.example.factory.service;

import com.example.factory.dtos.AddReviewDTO;
import com.example.factory.model.Order;
import com.example.factory.model.Review;
import com.example.factory.model.Review;
import com.example.factory.repository.ReviewRepository;
import com.example.factory.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {

    private final ReviewRepository reviewRepository;
    private final ItemService itemService;
    private final UserService userService;
    @Autowired
    public ReviewsService(ReviewRepository reviewRepository, ItemService itemService, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.itemService = itemService;
        this.userService = userService;
    }

    public ResponseEntity<Optional<Review>> addReview(AddReviewDTO reviewDTO) {
        try {
            Review review = new Review();
            review.setUser(userService.findByUsername(reviewDTO.getReviewAuthor()));
            review.setItem(itemService.getItemById(reviewDTO.getItemId()));
            review.setReviewAuthor(reviewDTO.getReviewAuthor());
            review.setReviewRating(review.getReviewRating());
            review.setReviewComment(review.getReviewComment());
            review.setReviewPublishDate(reviewDTO.getReviewPublishDate());
            return ResponseEntity.ok(Optional.of(reviewRepository.save(review)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsPageable(int pageNumber) {
        return reviewRepository.findAll(PageRequest.of(pageNumber, 10)).stream().toList();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public void deleteReview(Long id) { reviewRepository.deleteById(id);}

//    public Review updateReview(Long id, Review newReview) {
//
//        return reviewRepository.findById(id)
//                .map(order -> {
//                    if (newReview.getReviewName() != null) {
//                        order.setReviewName(newReview.getReviewName());
//                    }
//                    return reviewRepository.save(order);
//                })
//                .orElseGet(() -> {
//                    return reviewRepository.save(newReview);
//                });
//    }

//    public Review addReviewToCustomer(Customer customer, String orderName, Long machineId) {
//        Item machine = itemService.getItemById(machineId);
//
//        if (machine == null) {
//            System.out.println("Item not found!");
//            return null;
//        }
//
//        System.out.println("Item ID: " + machine.getItemId());
//        System.out.println("Item Name: " + machine.getItemName());
//
//        Review order = new Review(orderName);
//        order.getItems().add(machine);
//        order.setCustomer(customer);
//        customer.getReviews().add(order);
//        return reviewRepository.save(order);
//
//    }

//    public Review createReview(String orderName, Long machineId) {
//        Review order = new Review(orderName);
//
//        Item machine = itemService.getItemById(machineId);
//
//        if (machine == null) {
//            System.out.println("Item not found!");
//        }
//
//        order.getItems().add(machine);
//
//        return reviewRepository.save(order);
//    }

}
