package com.comprayahorraback.marketplace.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comprayahorraback.marketplace.dto_request.create.ProductCreateRequest;
import com.comprayahorraback.marketplace.dto_request.delete.ProductDeleteRequest;
import com.comprayahorraback.marketplace.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductCreateRequest createProductRequest){

        productService.createProduct(createProductRequest);
        return new ResponseEntity<>("Producto Creado", HttpStatus.CREATED);

    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestBody ProductDeleteRequest productDelete){
        try{
            productService.deleteProduct(productDelete);
            return new ResponseEntity<>("Poducto eliminado ", HttpStatus.ACCEPTED);    
        }catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Fallo al Eliminar Producto" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    } 
}