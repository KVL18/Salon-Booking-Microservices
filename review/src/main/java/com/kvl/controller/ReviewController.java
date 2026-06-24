package com.kvl.controller;


import com.kvl.model.Review;
import com.kvl.payload.dto.ApiResponse;
import com.kvl.payload.dto.ReviewRequest;
import com.kvl.payload.dto.SalonDTO;
import com.kvl.payload.dto.UserDTO;
import com.kvl.service.ReviewService;
import com.kvl.service.client.SalonFeignClient;
import com.kvl.service.client.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private  final ReviewService reviewService;
    private  final UserFeignClient userFeignClient;
    private  final SalonFeignClient salonFeignClient;

    @PostMapping("/salon/{salonId}")
    public ResponseEntity<Review> createReview(
            @PathVariable Long salonId,
            @RequestBody ReviewRequest request,
            @RequestHeader("Authorization") String jwt) throws Exception {

        UserDTO user = userFeignClient.getUserProfile(jwt).getBody();
        SalonDTO salon = salonFeignClient.getSalonById(salonId).getBody();

        Review review = reviewService.createReview(request,user,salon);

        return  ResponseEntity.ok(review);
    }

    @GetMapping("/salon/{salonId}")
    public ResponseEntity<List<Review>> getReviewBySalonId(
            @PathVariable Long salonId,
            @RequestHeader("Authorization") String jwt) throws Exception {

        SalonDTO salon = salonFeignClient.getSalonById(salonId).getBody();
        List<Review> reviews = reviewService.getReviewsBySalonId(salonId);

        return  ResponseEntity.ok(reviews);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review>  updateReview(
            @PathVariable Long reviewId,
            @RequestBody ReviewRequest request,
            @RequestHeader("Authorization") String jwt) throws Exception {

        UserDTO user = userFeignClient.getUserProfile(jwt).getBody();
        Review review = reviewService.updateReview(request,reviewId,user.getId());

        return  ResponseEntity.ok(review);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<ApiResponse>  updateReview(
            @PathVariable Long reviewId,
            @RequestHeader("Authorization") String jwt) throws Exception {

        UserDTO user = userFeignClient.getUserProfile(jwt).getBody();
        reviewService.deleteReview(reviewId,user.getId());

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Review Deleted");

        return  ResponseEntity.ok(apiResponse);
    }
}
