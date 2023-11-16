package com.comprayahorraback.marketplace.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comprayahorraback.marketplace.dto_request.ProductCreateRequest;
import com.comprayahorraback.marketplace.dto_response.ProductGetResponse;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductCreateRequest createProductRequest){

        try {
            productService.createProduct(createProductRequest);
            return new ResponseEntity<>("Product created", HttpStatus.CREATED);
        } catch (ConstraintViolationException e){
            return new ResponseEntity<>("Validation Error" + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        try {
            ProductGetResponse productGetResponse = productService.getProduct(id);

            if (productGetResponse != null) {
                return new ResponseEntity<>(productGetResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
            }

        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Validation Error" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductCreateRequest productCreateRequest, @PathVariable Long id){

        try {
            Product product = productService.updateProduct(id, productCreateRequest);

            if (product != null){
                return new ResponseEntity<>("Product Updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Validation Error", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        try{
            productService.deleteProduct(id);
            
            return new ResponseEntity<>("Product Successfully Removed", HttpStatus.ACCEPTED);    
        }catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Validation Error" + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>("Internal Server Error" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
}