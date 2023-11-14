package com.comprayahorraback.marketplace.mappers;

import com.comprayahorraback.marketplace.dto_request.create.ProductCreateRequest;
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

/*     public Product mapToDeleteEntityProduct(ProductDelete productDelete){
        Product product = new Product();

        product.setId(productDelete.getId());
        return product;
    } */
    
}
