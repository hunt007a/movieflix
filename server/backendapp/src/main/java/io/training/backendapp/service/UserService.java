package io.training.backendapp.service;

import java.util.List;

import io.training.backendapp.entity.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findById(String userId);
	
	public User create(User user);
	
	public User update(String userId, User user);
	
	public void remove(String userId);	
}
