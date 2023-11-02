package com.comprayahorraback.marketplace.service;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public Product createProduct(Product product){

        product.setArrival_date(LocalDate.now());

        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product updatedProduct) {

        if (productRepository.existsById(productId)) {
            updatedProduct.setId(productId);
            return productRepository.save(updatedProduct);
        } else {

            return null;
        }
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

}
