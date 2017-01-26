package io.training.backendapp.repository;

import java.util.List;

import io.training.backendapp.entity.Rating;

public interface RatingRepository {
	
	public List<Rating> findRatingByMovie(String movieId);
	
	public Rating findById(String ratingId);
	
	public Rating create(Rating rating);
	
	public Rating update(Rating existingRating);
	
	public void delete(Rating existingRating);
}