package io.training.backendapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.training.backendapp.entity.Comment;

@Repository
public class CommentRepositoryImpl implements CommentRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Comment> findCommentByMovie(String movieId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findByMovieId", Comment.class);
		query.setParameter("id", movieId);
		return query.getResultList();
	}

	@Override
	public Comment findById(String commentId) {
		return em.find(Comment.class, commentId);
	}

	@Override
	public Comment create(Comment comment) {
		em.persist(comment);
		return comment;
	}

	@Override
	public Comment update(Comment existingComment) {
		return em.merge(existingComment);
	}

	@Override
	public void delete(Comment existingComment) {	
		em.remove(existingComment);
	}
}
