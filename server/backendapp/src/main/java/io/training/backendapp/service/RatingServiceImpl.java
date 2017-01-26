package io.training.backendapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.training.backendapp.entity.Rating;
import io.training.backendapp.exception.RatingNotFoundException;
import io.training.backendapp.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	RatingRepository repository;

	@Override
	public List<Rating> findRatingByMovie(String movieId) {
		return repository.findRatingByMovie(movieId);
	}

	@Override
	public Rating findById(String ratingId) {
		Rating rating = repository.findById(ratingId);
		if(rating == null){
			throw new RatingNotFoundException("Rating not found with id="+ratingId);
		}
		return rating;
	}

	@Transactional
	@Override
	public Rating create(Rating rating) {
		return repository.create(rating);
	}

	@Transactional
	@Override
	public Rating update(String ratingId, Rating rating) {
		Rating existing = repository.findById(ratingId);
		if(existing == null){
			throw new RatingNotFoundException("Rating not found with id="+ratingId);
		}
		return repository.update(rating);
	}

	@Transactional
	@Override
	public void delete(String ratingId) {	
		Rating existing = repository.findById(ratingId);
		if(existing == null){
			throw new RatingNotFoundException("Rating not found with id="+ratingId);
		}
		repository.delete(existing);
	}
}
