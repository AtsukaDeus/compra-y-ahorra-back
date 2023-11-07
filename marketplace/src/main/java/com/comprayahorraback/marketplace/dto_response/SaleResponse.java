package com.comprayahorraback.marketplace.dto_response;


import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class SaleResponse {

    private Long id;
    private LocalDate sale_date;
    private String name_client;
    private String run_client;
    private double net;
    private double iva;
    private double gross;
    private List<ProductResponse> products_responses;

}
