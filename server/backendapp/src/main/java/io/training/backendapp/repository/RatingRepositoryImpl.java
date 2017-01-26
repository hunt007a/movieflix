package io.training.backendapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.training.backendapp.entity.Rating;

@Repository
public class RatingRepositoryImpl implements RatingRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Rating> findRatingByMovie(String movieId) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findByMovieId", Rating.class);
		query.setParameter("id", movieId);
		return query.getResultList();
	}

	@Override
	public Rating findById(String ratingId) {
		return em.find(Rating.class, ratingId);
	}

	@Override
	public Rating create(Rating rating) {
		em.persist(rating);
		return rating;
	}

	@Override
	public Rating update(Rating existingRating) {
		return em.merge(existingRating);
	}

	@Override
	public void delete(Rating existingRating) {	
		em.remove(existingRating);
	}
}
