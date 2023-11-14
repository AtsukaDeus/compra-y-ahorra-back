package com.comprayahorraback.marketplace.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comprayahorraback.marketplace.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    
    // this query is used to get the list of sales by sale_date of today
    @Query("select s from Sale s where date(s.sale_date) = current_date")
    List<Sale> findSalesBySaleDateToday(); 

    // this query is used to get the list of sales by sale_date of the week
    @Query("select s from Sale s where s.sale_date >= :startDate and s.sale_date <= :endDate")
    List<Sale> findSalesBySaleDateWeek(
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );

    // this query is used to get the list of sales by sale_date of the month
    @Query("SELECT s FROM Sale s WHERE YEAR(s.sale_date) = :year AND MONTH(s.sale_date) = :month AND s.sale_date <= :currentDate")
    List<Sale> findSalesByCurrentMonth(
        @Param("year") int year,
        @Param("month") int month,
        @Param("currentDate") LocalDate currentDate
    );

}

