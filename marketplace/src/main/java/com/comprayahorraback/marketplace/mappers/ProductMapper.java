package com.comprayahorraback.marketplace.mappers;

import com.comprayahorraback.marketplace.dto_request.ProductCreateRequest;
import com.comprayahorraback.marketplace.dto_response.ProductGetResponse;
import com.comprayahorraback.marketplace.entity.Category;

import com.comprayahorraback.marketplace.entity.Product;

public class ProductMapper {

    public Product mapToProductEntity(ProductCreateRequest createProductRequest){

        return Product.builder()
                        .name(createProductRequest.getName())
                        .price(createProductRequest.getPrice())
                        .stock(createProductRequest.getStock())
                        .category(Category.builder().id(createProductRequest.getCategory_id()).build())
                        .build();
    }

    public ProductGetResponse mapToProductGetResponse(Product product){

        return ProductGetResponse.builder()
                                .id(product.getId())
                                .name(product.getName())
                                .price(product.getPrice())
                                .stock(product.getStock())
                                .category_name(product.getCategory().getName())
                                .category_id(product.getCategory().getId())
                                .arrival_date(product.getArrival_date())
                                .build();
    }
    
}
