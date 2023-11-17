package com.comprayahorraback.marketplace.dto_request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingRequest {
    int value;
    Long userca_id;
    Long product_id;
}
