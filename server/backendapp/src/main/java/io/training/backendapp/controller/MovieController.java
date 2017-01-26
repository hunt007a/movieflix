package io.training.backendapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.training.backendapp.entity.Movie;
import io.training.backendapp.service.MovieService;

@RestController
@RequestMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {
	
	@Autowired
	MovieService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Movie findById(@PathVariable("id") String movieId){
		return service.findById(movieId);
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie){
		return service.create(movie);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/admin/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String movieId, @RequestBody Movie movie){
		return service.update(movieId, movie);	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/admin/{id}")
	public void delete(@PathVariable("id") String movieId){
		service.delete(movieId);
	}
	

	public MovieService getService() {
		return service;
	}

	public void setService(MovieService service) {
		this.service = service;
	}
	
}
