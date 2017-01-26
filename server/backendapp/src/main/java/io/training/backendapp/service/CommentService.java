package io.training.backendapp.service;

import java.util.List;

import io.training.backendapp.entity.Comment;

public interface CommentService {
	
	public List<Comment> findCommentByMovie(String movieId);
	
	public Comment findById(String commentId);
	
	public Comment create(Comment comment);
	
	public Comment update(String commentId, Comment comment);
	
	public void delete(String commentId);
}
