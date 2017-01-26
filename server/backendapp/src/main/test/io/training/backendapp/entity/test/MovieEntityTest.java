package io.training.backendapp.entity.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import io.training.backendapp.entity.Movie;

public class MovieEntityTest {
	 private Movie movie;
	 @Before
	 public void setupMock() {
		movie = new Movie();
		movie.setActors("Bradd Pit, Jennifer Aniston");
	 }
	 
	 @Test
	 public void testMovieEntity() {	
		assertEquals(movie.getActors(), "Bradd Pit, Jennifer Aniston");
	}

}
