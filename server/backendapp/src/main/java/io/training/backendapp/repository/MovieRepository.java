package io.training.backendapp.repository;

import java.util.List;

import io.training.backendapp.entity.Movie;

public interface MovieRepository {
	
	public List<Movie> findAll();
	
	public Movie findById(String movieId);
	
	public Movie findByImdbId(String imdbId);
	
	public Movie create(Movie movie);
	
	public Movie update(Movie existingMovie);
	
	public void delete(Movie existingMovie);
}
