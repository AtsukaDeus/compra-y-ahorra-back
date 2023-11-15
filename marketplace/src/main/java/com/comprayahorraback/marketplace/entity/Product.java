package com.comprayahorraback.marketplace.entity;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

import com.comprayahorraback.marketplace.configurations.LocalDateConverter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate arrival_date;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

}

