package com.comprayahorraback.marketplace.dto_response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingResponse {
    Long id;
    int value;
    Long userca_id;
    Long product_id;
}
