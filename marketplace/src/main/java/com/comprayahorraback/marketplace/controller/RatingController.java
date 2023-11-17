package com.comprayahorraback.marketplace.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comprayahorraback.marketplace.dto_request.RatingRequest;
import com.comprayahorraback.marketplace.dto_response.RatingResponse;
import com.comprayahorraback.marketplace.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
    
    @Autowired
    private RatingService ratingService;


    @GetMapping("/avg/{productId}")
    public ResponseEntity<?> getAvgRating(@PathVariable Long productId){

        try{
            double avgRating = ratingService.getAvgRating(productId);
            return new ResponseEntity<>(avgRating, HttpStatus.OK);

        } catch (Exception e){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/create")
    public ResponseEntity<?> createRating(@RequestBody RatingRequest request){
        try{
            ratingService.createRating(request);
            return new ResponseEntity<>("Rating ok", HttpStatus.OK);

        } 
        catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Bad Rating Request! " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
        catch (Exception e){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRating(@PathVariable Long id, @RequestBody RatingRequest request){

        try{
            ratingService.createRating(request);
            return new ResponseEntity<>("Rating ok", HttpStatus.OK);

        } 
        catch (ConstraintViolationException e) {
            return new ResponseEntity<>("Bad Rating Request! " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        
        catch (Exception e){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRating(@PathVariable Long id){
        try {
            boolean isDeleted = ratingService.deleteRating(id);
            if(isDeleted){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } 

        catch (Exception e){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/get")
    public ResponseEntity<?> getRating(
        @RequestParam("userca_id") Long usercaId,
        @RequestParam("product_id") Long productId
        ) {
            
        try {

            RatingResponse response = ratingService.getRating(usercaId, productId);
            if(response != null){
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            return new ResponseEntity<>("\"Userca\" or \"product\" does not exist!", HttpStatus.BAD_REQUEST);
        } 

        catch (Exception e){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
