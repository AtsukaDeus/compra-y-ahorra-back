package com.comprayahorraback.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comprayahorraback.marketplace.entity.SaleProduct;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Long>{
    List<SaleProduct> findBySaleId(Long saleId);
}
