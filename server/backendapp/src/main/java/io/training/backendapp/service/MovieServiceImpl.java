package io.training.backendapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.training.backendapp.entity.Movie;
import io.training.backendapp.exception.MovieAlreadyExistException;
import io.training.backendapp.exception.MovieNotFoundException;
import io.training.backendapp.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository repository;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findById(String movieId) {
		Movie movie = repository.findById(movieId);
		if(movie == null){
			throw new MovieNotFoundException("Movie not found with movieId="+movieId);
		}
		return movie;
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		Movie existing = repository.findByImdbId(movie.getImdbID());
		if(existing != null){
			throw new MovieAlreadyExistException("Movie already exist with imdbID="+movie.getImdbID());
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String movieId, Movie movie) {
		Movie existing = repository.findById(movieId);
		if(existing == null){
			throw new MovieNotFoundException("Movie not found with movieId="+movieId);
		}
		return repository.update(movie);
	}

	@Override
	@Transactional
	public void delete(String movieId) {	
		Movie existing = repository.findById(movieId);
		if(existing == null){
			throw new MovieNotFoundException("Movie not found with movieId="+movieId);
		}
		repository.delete(existing);
	}
	
	public MovieRepository getRepository() {
		return repository;
	}

	public void setRepository(MovieRepository repository) {
		this.repository = repository;
	}
}
