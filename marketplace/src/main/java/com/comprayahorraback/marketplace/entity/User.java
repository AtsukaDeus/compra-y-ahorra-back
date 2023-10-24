package com.comprayahorraback.marketplace.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String run;
    private String name;
    private String email;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;



}
