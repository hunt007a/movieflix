package io.training.backendapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.training.backendapp.entity.Comment;
import io.training.backendapp.exception.CommentNotFoundException;
import io.training.backendapp.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository repository;
	
	@Override
	public List<Comment> findCommentByMovie(String movieId) {
		return repository.findCommentByMovie(movieId);
	}

	@Override
	public Comment findById(String commentId) {
		Comment comment = repository.findById(commentId);
		if(comment == null){
			throw new CommentNotFoundException("Comment not found with id="+commentId);
		}
		return comment;
	}

	@Transactional
	@Override
	public Comment create(Comment comment) {
		return repository.create(comment);
	}

	@Transactional
	@Override
	public Comment update(String commentId, Comment comment) {
		Comment existing = repository.findById(commentId);
		if(existing == null){
			throw new CommentNotFoundException("Comment not found with id="+commentId);
		}
		return repository.update(comment);
	}

	@Transactional
	@Override
	public void delete(String commentId) {	
		Comment existing = repository.findById(commentId);
		if(existing == null){
			throw new CommentNotFoundException("Comment not found with id="+commentId);
		}
		repository.delete(existing);
	}
}