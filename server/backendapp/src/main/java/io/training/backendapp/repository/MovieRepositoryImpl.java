package io.training.backendapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.training.backendapp.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findById(String movieId) {
		return em.find(Movie.class, movieId);
	}

	@Override
	public Movie findByImdbId(String imdbId) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByImdbId", Movie.class);
		query.setParameter("imdbID", imdbId);
		List<Movie> movie = query.getResultList();
		if(movie.size() == 1){
			return movie.get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie existingMovie) {
		return em.merge(existingMovie);
	}

	@Override
	public void delete(Movie existingMovie) {	
		em.remove(existingMovie);
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
