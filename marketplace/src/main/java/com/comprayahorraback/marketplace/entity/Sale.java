package com.comprayahorraback.marketplace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;

import java.util.List;


@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate sale_date;
    private double net;
    private double iva;
    private double gross;
    @ManyToMany
    @JoinTable(
        name = "sale_product",
        joinColumns = @JoinColumn(name = "sale_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products_sold;

    public Sale(LocalDate sale_date, double net, double iva, double gross, List<Product> products_sold){   
        this.sale_date = sale_date;
        this.net = net;
        this.iva = iva;
        this.gross = gross;
        this.products_sold = products_sold;

    }

}
