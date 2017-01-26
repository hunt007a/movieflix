package io.training.backendapp.repository;

import java.util.List;

import io.training.backendapp.entity.User;

public interface UserRepository {
	
	public List<User> findAll();
	
	public User findById(String userId);
	
	public User findByEmail(String userEmail);
	
	public User create(User user);
	
	public User update(User existingUser);
	
	public void delete(User existingUser);
}
