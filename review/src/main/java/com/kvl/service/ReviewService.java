package com.kvl.service;

import com.kvl.model.Review;
import com.kvl.payload.dto.ReviewRequest;
import com.kvl.payload.dto.SalonDTO;
import com.kvl.payload.dto.UserDTO;

import java.util.List;

public interface ReviewService {

    Review createReview(ReviewRequest request, UserDTO user, SalonDTO salon);

    List<Review> getReviewsBySalonId(Long salonId);

    Review updateReview(ReviewRequest request, Long reviewId, Long userId) throws Exception;

    void deleteReview(Long reviewId,Long userId) throws Exception;
}
