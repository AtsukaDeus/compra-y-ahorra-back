package com.comprayahorraback.marketplace.mappers;

import com.comprayahorraback.marketplace.dto_request.ImageProductRequest;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.entity.ImageProduct;

public class ImageProductMapper {
    
    public ImageProduct requestToEntity(ImageProductRequest request, Product product){

        return ImageProduct.builder()
                            .image_path(request.getImage_path())
                            .product(product)
                            .build();
    }

}
