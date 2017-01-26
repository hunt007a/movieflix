package io.training.backendapp.service;

import java.util.List;

import io.training.backendapp.entity.Rating;

public interface RatingService {
	
	public List<Rating> findRatingByMovie(String movieId);
	
	public Rating findById(String ratingId);
	
	public Rating create(Rating rating);
	
	public Rating update(String ratingId, Rating rating);
	
	public void delete(String ratingId);
}
