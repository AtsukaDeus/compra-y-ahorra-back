package com.comprayahorraback.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprayahorraback.marketplace.dto_request.ImageProductRequest;
import com.comprayahorraback.marketplace.mappers.ImageProductMapper;
import com.comprayahorraback.marketplace.repository.ImageProductRepository;
import com.comprayahorraback.marketplace.repository.ProductRepository;
import com.comprayahorraback.marketplace.entity.ImageProduct;
import com.comprayahorraback.marketplace.entity.Product;

@Service
public class ImageProductService {
    
    @Autowired
    private ImageProductRepository imageProductRepository;

    @Autowired
    private ProductRepository productRepository;

    public ImageProduct createImage(ImageProductRequest request) {
        ImageProductMapper mapper = new ImageProductMapper();

        Product product = productRepository.findById(request.getProduct_id()).orElse(null);

        ImageProduct imageProduct = mapper.requestToEntity(request, product);
        imageProductRepository.save(imageProduct);

        return imageProduct;

    }

    public ImageProduct updateImage(ImageProductRequest request, Long id){
        
        ImageProductMapper mapper = new ImageProductMapper();
        ImageProduct imageProduct = new ImageProduct();

        Product product = productRepository.findById(request.getProduct_id()).orElse(null);

        if(imageProductRepository.existsById(id)){
            imageProduct = mapper.requestToEntity(request, product);
            imageProduct.setId(id);
            imageProductRepository.save(imageProduct);

        } else {
            imageProduct = null;
        }
        
        return imageProduct;
    }

    public boolean deleteImage(Long id) {
        
        boolean isImageDeleted = false;

        if(imageProductRepository.existsById(id))
        {
            imageProductRepository.deleteById(id);
            isImageDeleted = true;
        }
        
        return isImageDeleted;
    }

}




