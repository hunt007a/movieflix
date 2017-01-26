package io.training.backendapp.repository.test;

import static org.junit.Assert.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

import io.training.backendapp.entity.Movie;
import io.training.backendapp.repository.MovieRepositoryImpl;


import org.junit.Test;

public class MovieRepositoryTest {
	private List<Movie> movies;
	
	private String movieId = "M001";
	
	private String imdbID = "IM001";
	
	private MovieRepositoryImpl impl = new MovieRepositoryImpl();
	
	@Mock
	private EntityManager em;
	
	@Mock
	TypedQuery<Movie> query;
	
	@Before
	public void setUpMock(){
	   MockitoAnnotations.initMocks(this);
	   movies = new ArrayList<Movie>();
	   Movie fmovie = new Movie();
	   Movie smovie = new Movie();
	   movies.add(fmovie);
	   movies.add(smovie);
	   impl.setEm(em);
	}

	@Test
	public void testfindAll(){
		
		Mockito.when(em.createNamedQuery("Movie.findAll", Movie.class)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(movies);
		assertEquals(2,impl.findAll().size());
		Mockito.verify(query).getResultList();
	
	}
	
	@Test
	public void testFindById(){
		Movie existingMovie = new Movie();
		existingMovie.setId(movieId);
		Mockito.when(em.find(Movie.class, existingMovie.getId())).thenReturn(existingMovie);
		assertNotNull(impl.findById(existingMovie.getId()));
		Mockito.verify(em).find(Movie.class, existingMovie.getId());
	}
	
	@Test
	public void testFindByImdbId(){
		List<Movie> movieList = new ArrayList<Movie>();
		Movie existingMovie = new Movie();
		movieList.add(existingMovie);
		existingMovie.setImdbID(imdbID);
		Mockito.when(em.createNamedQuery("Movie.findByImdbId", Movie.class)).thenReturn(query);
		query.setParameter("imdbID", existingMovie.getImdbID());
		Mockito.when(query.getResultList()).thenReturn(movieList);
		assertNotNull(impl.findByImdbId(existingMovie.getImdbID()));
		assertEquals("IM001",impl.findByImdbId(existingMovie.getImdbID()).getImdbID());
		
	}
	
	@Test
	public void testCreate(){
		Movie newMovie = new Movie();
		newMovie.setId(movieId);
		Mockito.doNothing().when(em).persist(newMovie);
		assertSame("They are not same", newMovie, impl.create(newMovie));

		
	}
	
	@Test
	public void testUpdate(){
		Movie existingMovie = new Movie();
		Mockito.when(em.merge(existingMovie)).thenReturn(existingMovie);
		assertSame("They are not same", existingMovie, impl.update(existingMovie));
		
	}
	
	@Test
	public void testDelete(){
		Movie existingMovie = new Movie();
		Mockito.doNothing().when(em).remove(existingMovie);
		impl.delete(existingMovie);
		Mockito.verify(em).remove(existingMovie);
	}
	

}
