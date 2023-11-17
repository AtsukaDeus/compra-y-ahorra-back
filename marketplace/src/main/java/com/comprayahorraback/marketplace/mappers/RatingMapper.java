package com.comprayahorraback.marketplace.mappers;

import com.comprayahorraback.marketplace.dto_request.RatingRequest;
import com.comprayahorraback.marketplace.dto_response.RatingResponse;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.entity.Rating;
import com.comprayahorraback.marketplace.entity.Userca;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RatingMapper {

    public Rating toEntity(RatingRequest request){
        
        return Rating.builder()
                    .value(request.getValue())
                    .userca(Userca.builder().id(request.getUserca_id()).build())
                    .product(Product.builder().id(request.getProduct_id()).build())
                    .build();
                    
    }


    public RatingResponse toResponse(Rating rating){

        return RatingResponse.builder()
                            .id(rating.getId())
                            .value(rating.getValue())
                            .userca_id(rating.getUserca().getId())
                            .product_id(rating.getProduct().getId())
                            .build();

    }


}
