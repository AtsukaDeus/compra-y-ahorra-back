package com.comprayahorraback.marketplace.dto_request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProductCreateRequest {
    private String name;
    private Double price;
    private int stock;
    private Long category_id;
    private List<ImageProductRequest> images;
}


