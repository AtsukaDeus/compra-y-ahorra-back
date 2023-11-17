package com.comprayahorraback.marketplace.service;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.comprayahorraback.marketplace.dto_request.ProductCreateRequest;
import com.comprayahorraback.marketplace.dto_response.ProductGetResponse;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.mappers.ProductMapper;
import com.comprayahorraback.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public Product createProduct(ProductCreateRequest createProductRequest){

        ProductMapper productMapper = new ProductMapper();

        Product product = productMapper.mapToProductEntity(createProductRequest);

        product.setArrival_date(LocalDate.now());
        product.setLast_modified(LocalDate.now());

        return productRepository.save(product);
    }


    public boolean deleteProduct(Long id){

        boolean isProductDeleted = false;

        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            isProductDeleted = true;
        }
        
        return isProductDeleted;

    }

    public ProductGetResponse getProduct(Long id) {

        ProductMapper productMapper = new ProductMapper();
        ProductGetResponse productGetResponse = new ProductGetResponse();
        Product product = new Product();

        product = productRepository.findById(id).orElse(null);

        productGetResponse = productMapper.mapToProductGetResponse(product);

        return productGetResponse;
    }


    public Product updateProduct(Long id, ProductCreateRequest productCreateRequest) {
        ProductMapper productMapper = new ProductMapper();
        Product product = new Product();
        
        if (productRepository.existsById(id)) {
            product = productMapper.mapToProductEntity(productCreateRequest);
            product.setLast_modified(LocalDate.now());
            product.setId(id);
            productRepository.save(product);
        } else {
            product = null;
        }
        return product;
    }

}
