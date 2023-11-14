package com.comprayahorraback.marketplace.mappers;


import com.comprayahorraback.marketplace.dto_request.CommentRequest;
import com.comprayahorraback.marketplace.entity.Comment;
import com.comprayahorraback.marketplace.entity.Product;
import com.comprayahorraback.marketplace.entity.Userca;

public class CommentMapper {


    public Comment requestToEntity(CommentRequest request, Userca userca, Product product){

        return Comment.builder()
                        .body(request.getBody())
                        .userca(userca)
                        .product(product)
                        .build();
    }

}
