package com.comprayahorraback.marketplace.mappers;

import com.comprayahorraback.marketplace.dto_request.ProductCreateRequest;
import com.comprayahorraback.marketplace.dto_response.ProductGetResponse;
import com.comprayahorraback.marketplace.entity.Category;

import com.comprayahorraback.marketplace.entity.Product;

public class ProductMapper {

    public Product mapToProductEntity(ProductCreateRequest createProductRequest){
        Product product = new Product();
        Category category = new Category();

        product.setName(createProductRequest.getName());
        product.setPrice(createProductRequest.getPrice());
        product.setStock(createProductRequest.getStock());

        category.setId(createProductRequest.getCategory_id());
        product.setCategory(category);
    
        return product;
    }

    public ProductGetResponse mapToProductGetResponse(Product product){
        ProductGetResponse productGetResponse = new ProductGetResponse();

        productGetResponse.setId(product.getId());
        productGetResponse.setName(product.getName());
        productGetResponse.setPrice(product.getPrice());
        productGetResponse.setStock(product.getStock());
        productGetResponse.setCategory_name(product.getCategory().getName());
        productGetResponse.setCategory_id(product.getCategory().getId());
        productGetResponse.setArrival_date(product.getArrival_date());

        return productGetResponse;
    }
    
}
