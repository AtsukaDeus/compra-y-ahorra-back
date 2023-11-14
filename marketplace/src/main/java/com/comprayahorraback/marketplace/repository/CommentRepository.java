package com.comprayahorraback.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprayahorraback.marketplace.entity.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long>{

} 
