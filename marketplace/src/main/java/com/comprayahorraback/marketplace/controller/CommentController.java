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

import com.comprayahorraback.marketplace.dto_request.CommentRequest;
import com.comprayahorraback.marketplace.entity.Comment;
import com.comprayahorraback.marketplace.service.CommentService;



@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<?> createComment(@RequestBody CommentRequest request){
        try {    
            Comment comment = commentService.createComment(request);
            if(comment != null){
                return new ResponseEntity<>("Comment created successfully!", HttpStatus.CREATED);
            
            } else{
                return new ResponseEntity<>("Comment not created!", HttpStatus.BAD_REQUEST);
            }
            
        } 
        
        catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateComment(@RequestBody CommentRequest request, @PathVariable Long id){
        try {    
            Comment comment = commentService.updateComment(request, id);
            if(comment != null){
                return ResponseEntity.ok("Comment Updated!");
            
            } else{
                return new ResponseEntity<>("Comment not Updated!", HttpStatus.BAD_REQUEST);
            }
            
        } 
        
        catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }


    @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteComment(@PathVariable Long id){
        try {    
            boolean isCommentDeleted = commentService.deleteComment(id);
            if(isCommentDeleted){
                return ResponseEntity.ok("Comment deleted!");
            
            } else{
                return new ResponseEntity<>("Comment not founded!", HttpStatus.BAD_REQUEST);
            }
            
        } 
        
        catch (Exception e) {
            return new ResponseEntity<>("Error interno del servidor: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }

    



    
}
