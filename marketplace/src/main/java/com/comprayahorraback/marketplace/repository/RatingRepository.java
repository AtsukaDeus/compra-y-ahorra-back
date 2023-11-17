package com.comprayahorraback.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comprayahorraback.marketplace.entity.Rating;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("select avg(r.value) from Rating r where r.product.id = :productId")
    double getAvgRatingByProductId(@Param("productId") Long productId);


    @Query("select r from Rating r where r.userca.id = :usercaId and r.product.id = :productId")
    Rating findRatingByUsercaIdAndProductId(Long usercaId, Long productId);

} 
