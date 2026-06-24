package com.kvl.repository;


import com.kvl.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findBySalonId(Long salonId);
}
