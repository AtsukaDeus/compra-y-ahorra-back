package com.comprayahorraback.marketplace.dto_request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductCreateRequest {
    private String name;
    private Double price;
    private int stock;
    private Long category_id;
}


