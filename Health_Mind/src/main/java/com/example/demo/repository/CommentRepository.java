package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Comment;

@Repository("commentRepository")
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
