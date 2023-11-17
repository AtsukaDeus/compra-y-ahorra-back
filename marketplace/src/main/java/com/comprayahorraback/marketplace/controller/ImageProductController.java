package com.comprayahorraback.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comprayahorraback.marketplace.dto_request.ImageProductRequest;
import com.comprayahorraback.marketplace.service.ImageProductService;
import com.comprayahorraback.marketplace.entity.ImageProduct;

@RestController
@RequestMapping("/image")
public class ImageProductController {

    @Autowired
    ImageProductService imageProductService;

    @PostMapping("/create")
    public ResponseEntity<?> createImageProduct(@RequestBody ImageProductRequest request){
        try {    
            ImageProduct imageProduct = imageProductService.createImage(request);
            if(imageProduct != null){
                return new ResponseEntity<>("Image inserted successfully!", HttpStatus.CREATED);
            
            } else{
                return new ResponseEntity<>("Image Not Inserted", HttpStatus.BAD_REQUEST);
            }
            
        } 
        
        catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateImage(@RequestBody ImageProductRequest request, @PathVariable Long id){
        try {    
            ImageProduct imageProduct = imageProductService.updateImage(request, id);
            if(imageProduct != null){
                return ResponseEntity.ok("Image Updated!");
            
            } else{
                return new ResponseEntity<>("Image not Updated!", HttpStatus.BAD_REQUEST);
            }
            
        } 
        
        catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }

    @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteImage(@PathVariable Long id){
        try {    
            boolean isImageDeleted = imageProductService.deleteImage(id);
            if(isImageDeleted){
                return ResponseEntity.ok("Image Deleted!");
            
            } else{
                return new ResponseEntity<>("Image not Deleted!", HttpStatus.BAD_REQUEST);
            }
            
        } 
        
        catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }


}
