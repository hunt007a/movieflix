package io.training.backendapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.training.backendapp.entity.Comment;
import io.training.backendapp.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	CommentService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/movie/{movieId}/comment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comment> findCommentByMovie(@PathVariable("movieId") String movieId){
		return service.findCommentByMovie(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/comment/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment findById(@PathVariable("id") String commentId){
		return service.findById(commentId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/comment", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment createComment(@RequestBody Comment comment){
		return service.create(comment);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/comment/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment updateComment(@PathVariable("id") String commentId, @RequestBody Comment comment){
		return service.update(commentId, comment);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/comment/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void deleteComment(@PathVariable("id") String commentId) {
		service.delete(commentId);
	}

}
