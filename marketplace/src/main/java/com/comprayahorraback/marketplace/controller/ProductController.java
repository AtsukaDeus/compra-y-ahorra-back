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
            return new ResponseEntity<>("Producto Creado", HttpStatus.CREATED);
        } catch (ConstraintViolationException e){
            return new ResponseEntity<>("Error al crear Producto" + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        try {
            ProductGetResponse productGetResponse = productService.getProduct(id);

            if (productGetResponse != null) {
                return new ResponseEntity<>(productGetResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
            }

        } catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Error al traer el producto" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody ProductCreateRequest productCreateRequest, @PathVariable Long id){

        try {
            Product product = productService.updateProduct(id, productCreateRequest);

            if (product != null){
                return new ResponseEntity<>("Producto actualizado", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No se ha podido actualizar el Producto", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        try{
            productService.deleteProduct(id);
            return new ResponseEntity<>("Poducto eliminado ", HttpStatus.ACCEPTED);    
        }catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Error al Eliminar Producto" + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>("Error interno del servidor" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 
}