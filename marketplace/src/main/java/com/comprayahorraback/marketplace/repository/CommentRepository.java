package com.comprayahorraback.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comprayahorraback.marketplace.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

} 
