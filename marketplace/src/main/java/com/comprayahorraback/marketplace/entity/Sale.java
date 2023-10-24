package com.comprayahorraback.marketplace.entity;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.List;

import com.comprayahorraback.marketplace.configurations.LocalDateConverter;


@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate sale_date;    
    private double net;
    private double iva;
    private double gross;
    @ManyToOne
    @JoinColumn(name = "userca_id")
    private UserCa userca;

    @ManyToMany
    @JoinTable(
        name = "sale_product",
        joinColumns = @JoinColumn(name = "sale_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products_sold;



    public Long getId(){return this.id;}
    public LocalDate getSaleDate(){return this.sale_date;}
    public double getNet(){return this.net;}
    public double getIva(){return this.iva;}
    public double getGross(){return this.gross;}
    public UserCa getUserCA(){return this.userca;}
    public List<Product> getProductsSold(){return this.products_sold;}

    public void setSaleDate(LocalDate sale_date){this.sale_date = sale_date;}
    public void setNet(double net){this.net = net;}
    public void setIva(double iva){this.iva = iva;}
    public void setGross(double gross){this.gross = gross;}
    public void setProductsSold(List<Product> products_sold){this.products_sold = products_sold;}

}
