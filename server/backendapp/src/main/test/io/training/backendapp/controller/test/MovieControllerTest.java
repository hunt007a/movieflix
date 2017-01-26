package io.training.backendapp.controller.test;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.mockito.*;

import io.training.backendapp.controller.MovieController;
import io.training.backendapp.entity.Movie;
import io.training.backendapp.service.MovieService;

import org.junit.Test;


public class MovieControllerTest {
	
	@Mock
    private MovieService service;
	
	private MovieController controller = new MovieController();
	
	private List<Movie> movies;
	
	private String movieId = "M001";
	
	
	@Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
	   	movies = new ArrayList<Movie>();
		Movie fmovie = new Movie();
		Movie smovie = new Movie();
		movies.add(fmovie);
		movies.add(smovie);
		controller.setService(service);
    }

	@Test
	public void testfindAll() {

		Mockito.when(service.findAll()).thenReturn(movies);
		assertEquals(movies,controller.findAll());
		Mockito.verify(service).findAll();
		assertEquals(2,controller.findAll().size());
	}
	
	@Test
	public void testfindById(){
		Movie existingMovie = new Movie();
		Mockito.when(service.findById(movieId)).thenReturn(existingMovie);
		assertNotNull(controller.findById(movieId));
		Mockito.verify(service).findById(movieId);

	}
	
	@Test
	public void create(){
		Movie newMovie = new Movie();
		Mockito.when(service.create(newMovie)).thenReturn(newMovie);
		assertEquals(newMovie, controller.create(newMovie));
		Mockito.verify(service).create(newMovie);	
	}
	
	@Test
	public void update(){
		Movie existingMovie = new Movie();
		Mockito.when(service.update(movieId, existingMovie)).thenReturn(existingMovie);
		assertEquals(existingMovie, controller.update(movieId,existingMovie));
		Mockito.verify(service).update(movieId,existingMovie);	
	}
	
	@Test
	public void delete(){
		Mockito.doNothing().when(service).delete(movieId);
		controller.delete(movieId);
		Mockito.verify(service).delete(movieId);	
	}


}
