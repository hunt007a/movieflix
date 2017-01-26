package io.training.backendapp.service.test;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.mockito.*;
import org.mockito.MockitoAnnotations;


import io.training.backendapp.entity.Movie;
import io.training.backendapp.exception.MovieAlreadyExistException;
import io.training.backendapp.exception.MovieNotFoundException;
import io.training.backendapp.repository.MovieRepository;
import io.training.backendapp.service.MovieServiceImpl;

import org.junit.Test;

public class MovieServiceTest {
	private List<Movie> movies;
	
	private MovieServiceImpl service = new MovieServiceImpl();
	
	private String movieId = "M001";
	
	private String imdbID = "IM001";
	
	@Mock
	private MovieRepository repository;
	
	@Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
	   	movies = new ArrayList<Movie>();
		Movie fmovie = new Movie();
		Movie smovie = new Movie();
		movies.add(fmovie);
		movies.add(smovie);
		service.setRepository(repository);
    }
	
	@Test
	public void testfindAll() {
		Mockito.when(repository.findAll()).thenReturn(movies);
		service.findAll();
		Mockito.verify(repository).findAll();
		assertEquals(movies,service.findAll());
		assertEquals(2,service.findAll().size());
		
	}
	
	@Test
	public void testFindById() {
		Mockito.when(repository.findById(movieId)).thenReturn(movies.get(0));
		service.findById(movieId);
		Mockito.verify(repository).findById(movieId);
		assertEquals(movies.get(0),service.findById(movieId));
	}
	
	@Test(expected = MovieNotFoundException.class)
	public void testFindByIdWithException() throws MovieNotFoundException{
		Mockito.when(repository.findById(movieId)).thenReturn(null);
		try{
			service.findById(movieId);
		   }
		catch(MovieNotFoundException e){
			Mockito.verify(repository).findById(movieId);
			throw e;
		}
		
	}
	
	@Test
	public void testCreate(){
		Mockito.when(repository.findByImdbId(imdbID)).thenReturn(null);
		Movie newMovie = new Movie();
		newMovie.setImdbID(imdbID);
		Mockito.when(repository.create(newMovie)).thenReturn(newMovie);
		service.create(newMovie);
		Mockito.verify(repository).findByImdbId(imdbID);
		Mockito.verify(repository).create(newMovie);
		assertSame("Objects are not same",newMovie, service.create(newMovie));
		
	}
	
	@Test(expected = MovieAlreadyExistException.class)
	public void testCreateWithException() throws MovieAlreadyExistException{
		Movie existingMovie = new Movie();
		existingMovie.setImdbID(imdbID);
		Mockito.when(repository.findByImdbId(imdbID)).thenReturn(existingMovie);
		try{
			service.create(existingMovie);
		}
		catch(MovieAlreadyExistException e){
			Mockito.verify(repository, Mockito.times(0)).create(existingMovie);
			throw e;
		}
	}
	
	@Test
	public void testUpdate(){
		Movie existingMovie = new Movie();
		Mockito.when(repository.findById(movieId)).thenReturn(existingMovie);
		Mockito.when(repository.update(existingMovie)).thenReturn(existingMovie);
		service.update(movieId, existingMovie);
		Mockito.verify(repository).findById(movieId);
		Mockito.verify(repository).update(existingMovie);
		assertSame("Objects are not same",existingMovie, service.update(movieId,existingMovie));
	}
	
	@Test(expected = MovieNotFoundException.class)
	public void testUpdateWithException() throws MovieNotFoundException{
		Movie existingMovie = new Movie();
		Mockito.when(repository.findById(movieId)).thenReturn(null);
		try{
			service.update(movieId, existingMovie);
		}
		catch(MovieNotFoundException e){
			Mockito.verify(repository, Mockito.times(0)).update(existingMovie);
			throw e;
		}
		
	}
	
	@Test
	public void delete(){
		Movie existingMovie = new Movie();
		Mockito.when(repository.findById(movieId)).thenReturn(existingMovie);
	    Mockito.doNothing().when(repository).delete(existingMovie);
		service.delete(movieId);
		Mockito.verify(repository).findById(movieId);
		Mockito.verify(repository).delete(existingMovie);
	}
	
	@Test(expected = MovieNotFoundException.class)
	public void deleteWithException() throws MovieNotFoundException{
		Movie existingMovie = new Movie();
		Mockito.when(repository.findById(movieId)).thenReturn(null);
		try{
			service.delete(movieId);
		}
		catch(MovieNotFoundException e){
			Mockito.verify(repository, Mockito.times(0)).delete(existingMovie);
			throw e;
		}
	}

}
