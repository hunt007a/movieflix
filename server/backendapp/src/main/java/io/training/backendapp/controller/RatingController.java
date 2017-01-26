package io.training.backendapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.training.backendapp.entity.Rating;
import io.training.backendapp.service.RatingService;

@RestController
public class RatingController {
	
	@Autowired
	RatingService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/movie/{movieId}/rating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Rating> findRatingByMovie(@PathVariable("movieId") String movieId){
		return service.findRatingByMovie(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/rating/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating findById(@PathVariable("id") String ratingId){
		return service.findById(ratingId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/rating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating createRating(@RequestBody Rating rating){
		return service.create(rating);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/rating/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating updateRating(@PathVariable("id") String ratingId, @RequestBody Rating rating){
		return service.update(ratingId, rating);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/rating/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void deleteRating(@PathVariable("id") String ratingId) {
		service.delete(ratingId);
	}
}
