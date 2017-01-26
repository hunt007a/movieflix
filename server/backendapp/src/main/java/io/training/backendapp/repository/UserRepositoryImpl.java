package io.training.backendapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.training.backendapp.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findById(String userId) {
		return em.find(User.class, userId);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("email", email);
		List<User> user = query.getResultList();
		if(user.size() == 1){
			return user.get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User existingUser) {
		return em.merge(existingUser);
	}

	@Override
	public void delete(User existingUser) {		
		em.remove(existingUser);
	}
}
