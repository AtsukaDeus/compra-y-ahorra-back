package com.comprayahorraback.marketplace.service;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.comprayahorraback.marketplace.dto_request.CreateProductRequest;
import com.comprayahorraback.marketplace.dto_request.delete.ProductDelete;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.mappers.ProductMapper;
import com.comprayahorraback.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public Product createProduct(CreateProductRequest createProductRequest){

        ProductMapper productMapper = new ProductMapper();

        Product product = productMapper.mapToProductEntity(createProductRequest);

        product.setArrival_date(LocalDate.now());
         
        return productRepository.save(product);
    }


    public void deleteProduct(ProductDelete productDelete){
        
        Long productId = productDelete.getId();
        
        productRepository.deleteById(productId);
    }


    public Product updateProduct(Long productId, Product updatedProduct) {

        if (productRepository.existsById(productId)) {
            updatedProduct.setId(productId);
            return productRepository.save(updatedProduct);
        } else {

            return null;
        }
    }

}
