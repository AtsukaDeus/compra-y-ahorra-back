package com.comprayahorraback.marketplace.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comprayahorraback.marketplace.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
