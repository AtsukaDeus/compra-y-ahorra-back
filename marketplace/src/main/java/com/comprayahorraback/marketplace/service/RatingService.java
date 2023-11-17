package com.comprayahorraback.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprayahorraback.marketplace.dto_request.RatingRequest;
import com.comprayahorraback.marketplace.dto_response.RatingResponse;
import com.comprayahorraback.marketplace.entity.Rating;
import com.comprayahorraback.marketplace.mappers.RatingMapper;
import com.comprayahorraback.marketplace.repository.ProductRepository;
import com.comprayahorraback.marketplace.repository.RatingRepository;
import com.comprayahorraback.marketplace.repository.UsercaRepository;

@Service
public class RatingService {

        @Autowired
        private RatingRepository ratingRepository;

        @Autowired
        private UsercaRepository usercaRepository;

        @Autowired
        private ProductRepository productRepository;



        
        public double getAvgRating(Long productId){

            if(productRepository.existsById(productId)){
                return ratingRepository.getAvgRatingByProductId(productId);
            }
            return 0;
        }


        public void createRating(RatingRequest request){
            
            ratingRepository.save(new RatingMapper().toEntity(request));
        }


        public Rating updateRating(Long id, RatingRequest request){
            Rating rating = new Rating();

            if(ratingRepository.existsById(id)){
                rating = new RatingMapper().toEntity(request);
                rating.setId(id);
                return ratingRepository.save(rating);
            }   

            return null;
        }


        public boolean deleteRating(Long id){
            if(ratingRepository.existsById(id)){
                ratingRepository.deleteById(id);
                return true;
            }  
            return false;
        }


        public RatingResponse getRating(Long usercaId, Long productId){

            if(usercaRepository.existsById(usercaId) && productRepository.existsById(productId)){
                Rating rating = ratingRepository.findRatingByUsercaIdAndProductId(usercaId, productId);
                return new RatingMapper().toResponse(rating);
            }

            return null;
        }


}
