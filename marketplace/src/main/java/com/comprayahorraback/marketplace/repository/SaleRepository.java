package com.comprayahorraback.marketplace.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comprayahorraback.marketplace.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    
    // this query is used to get the list of sales by sale_date of today
    @Query("select s from Sale s where date(s.sale_date) = current_date")
    List<Sale> findSalesBySaleDateToday(); 

    // Consulta personalizada para buscar ventas por fecha
    // @Query("SELECT s FROM Sale s WHERE s.sale_date = :fecha")
    // List<Sale> findBySaleDate(@Param("fecha") LocalDate fecha);
    
    // Agrega otras consultas personalizadas si es necesario
}

