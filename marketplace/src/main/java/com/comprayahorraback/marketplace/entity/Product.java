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
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String name, double price, LocalDate arrival_date, Category category, int stock){
        this.name = name;
        this.price = price;
        this.arrival_date = arrival_date;
        this.category = category;
        this.stock = stock;
    }

        public Long getId(){
            return id;
        }

        public void setID(Long id){
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
        
        public double getPrice() {
            return price;
        }
    
        public void setPrice(double price) {
            this.price = price;
        }
    
        public LocalDate getArrivalDate() {
            return arrival_date;
        }
    
        public void setArrivalDate(LocalDate arrival_date) {
            this.arrival_date = arrival_date;
        }
    
        public int getStock() {
            return stock;
        }
    
        public void setStock(int stock) {
            this.stock = stock;
        }
    
        public Category getCategory() {
            return category;
        }
    
        public void setCategory(Category category) {
            this.category = category;
        }
}

