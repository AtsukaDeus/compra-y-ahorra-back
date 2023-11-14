package com.comprayahorraback.marketplace.dto_request;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class SaleRequest {
    private double net;
    private Long user_id;
    private List<ProductSaleRequest> products_sold;
}
