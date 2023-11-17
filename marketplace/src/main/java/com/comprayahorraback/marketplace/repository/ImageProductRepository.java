package com.comprayahorraback.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprayahorraback.marketplace.entity.ImageProduct;

public interface ImageProductRepository extends JpaRepository<ImageProduct, Long> {
    
}
