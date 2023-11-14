package com.comprayahorraback.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprayahorraback.marketplace.dto_request.CommentRequest;
import com.comprayahorraback.marketplace.entity.Comment;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.entity.Userca;
import com.comprayahorraback.marketplace.mappers.CommentMapper;
import com.comprayahorraback.marketplace.repository.CommentRepository;
import com.comprayahorraback.marketplace.repository.ProductRepository;
import com.comprayahorraback.marketplace.repository.UsercaRepository;




@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UsercaRepository usercaRepository;

    @Autowired 
    private ProductRepository productRepository;


    // method to create a comment
    public Comment createComment(CommentRequest request){

        CommentMapper commentMapper = new CommentMapper();

        Userca userca = usercaRepository.findById(request.getUserca_id()).orElse(null);
        Product product = productRepository.findById(request.getProduct_id()).orElse(null);

        Comment comment = commentMapper.requestToEntity(request, userca, product);
        commentRepository.save(comment);
        return comment;        
    }


    // method to update a comment
    public Comment updateComment(CommentRequest request, Long id){
        
        CommentMapper commentMapper = new CommentMapper();
        Comment comment = new Comment();

        Userca userca = usercaRepository.findById(request.getUserca_id()).orElse(null);
        Product product = productRepository.findById(request.getProduct_id()).orElse(null);

        if(commentRepository.existsById(id)){
            comment = commentMapper.requestToEntity(request, userca, product);
            comment.setId(id);
            commentRepository.save(comment);

        } else {
            comment = null;
        }
        
        return comment;
    }


    // method to delete a comment
    public boolean deleteComment(Long id) {
        
        boolean isCommentDeleted = false;

        if(commentRepository.existsById(id)){
            commentRepository.deleteById(id);
            isCommentDeleted = true;
        }
        
        return isCommentDeleted;
    }

}
