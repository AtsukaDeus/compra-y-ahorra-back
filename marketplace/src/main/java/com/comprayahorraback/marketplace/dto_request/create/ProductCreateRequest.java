package com.comprayahorraback.marketplace.dto_request.create;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductCreate {
    private String name;
    private Double price;
    private int stock;
    private Long category_id;
}


