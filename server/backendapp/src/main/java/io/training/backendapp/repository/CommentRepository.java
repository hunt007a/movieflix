package io.training.backendapp.repository;

import java.util.List;

import io.training.backendapp.entity.Comment;

public interface CommentRepository {
	
	public List<Comment> findCommentByMovie(String movieId);
	
	public Comment findById(String commentId);
	
	public Comment create(Comment comment);
	
	public Comment update(Comment existingComment);
	
	public void delete(Comment existingComment);
}