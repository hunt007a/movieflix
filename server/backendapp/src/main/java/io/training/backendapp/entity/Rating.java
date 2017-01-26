package io.training.backendapp.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Rating.findByMovieId", query = "Select r from Rating r where r.movie.id = :id")
})
public class Rating {
	
	@Id
	private String id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Movie movie;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	private int ratingValue;
	
	public Rating(){
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}	
}
