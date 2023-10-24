package com.comprayahorraback.marketplace.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.comprayahorraback.marketplace.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
