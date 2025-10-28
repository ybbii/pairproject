package com.example.review.controller;

import com.example.review.model.Review;
import com.example.review.repository.ReviewRepository;
import com.example.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @GetMapping
    public List<Review> getReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/movie/{movieId}")
    public List<Review> getReviewsByMovie(@PathVariable Long movieId) {
        return reviewService.getReviewsByMovie(movieId);
    }

    @GetMapping("/user/{userId}")
    public List<Review> getReviewsByUser(@PathVariable Long userId) {
        return reviewService.getReviewsByUser(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "Review deleted";
    }
}
