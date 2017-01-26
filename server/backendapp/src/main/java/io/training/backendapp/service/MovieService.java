package io.training.backendapp.service;

import java.util.List;

import io.training.backendapp.entity.Movie;

public interface MovieService {
	
	public List<Movie> findAll();
	
	public Movie findById(String movieId);
	
	public Movie create(Movie movie);
	
	public Movie update(String movieId, Movie movie);
	
	public void delete(String movieId);
}
