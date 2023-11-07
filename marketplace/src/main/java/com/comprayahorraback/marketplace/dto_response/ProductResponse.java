package com.comprayahorraback.marketplace.dto_response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ProductResponse {
    
    private Long id;
    private String name;
    private double net;
    private double iva;
    private double gross;
    private int quantity;
    
}
