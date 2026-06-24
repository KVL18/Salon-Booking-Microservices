package com.kvl.service.impl;

import com.kvl.model.Review;
import com.kvl.payload.dto.ReviewRequest;
import com.kvl.payload.dto.SalonDTO;
import com.kvl.payload.dto.UserDTO;
import com.kvl.repository.ReviewRepository;
import com.kvl.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review createReview(ReviewRequest request, UserDTO user, SalonDTO salon) {
        Review review = new Review();
        review.setReviewText(request.getReviewText());
        review.setRating(request.getRating());
        review.setUserId(user.getId());
        review.setSalonId(salon.getId());

        return  reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsBySalonId(Long salonId) {
        return reviewRepository.findBySalonId(salonId);
    }

    private Review getReviewById(Long id) throws Exception {
        return reviewRepository.findById(id).orElseThrow(()->new Exception("" +
                "review not exist"));
    }

    @Override
    public Review updateReview(ReviewRequest request, Long reviewId, Long userId) throws Exception {

        Review review = getReviewById(reviewId);
        if(!review.getUserId().equals(userId)){
            throw  new Exception("you don't have permission to update");
        }
        review.setReviewText(request.getReviewText());
        review.setRating(request.getRating());
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long reviewId, Long userId) throws Exception {
        Review review = getReviewById(reviewId);
        if(!review.getUserId().equals(userId)){
            throw  new Exception("you don't have permission to delete");
        }
        reviewRepository.delete(review);

    }
}
