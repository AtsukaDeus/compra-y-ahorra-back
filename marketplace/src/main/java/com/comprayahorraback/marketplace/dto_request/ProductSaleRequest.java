package com.comprayahorraback.marketplace.dto_request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ProductSaleRequest {
    private Long id;
    private int quantity;
}
