package com.comprayahorraback.marketplace.dto_response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductGetResponse {
    private Long id;
    private String name;
    private Double price;
    private int stock;
    private String category_name;
    private Long category_id;
    private LocalDate arrival_date;
}
