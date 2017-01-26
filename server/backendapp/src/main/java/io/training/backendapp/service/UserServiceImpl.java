package io.training.backendapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.training.backendapp.entity.User;
import io.training.backendapp.exception.UserAlreadyExistException;
import io.training.backendapp.exception.UserNotFoundException;
import io.training.backendapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(String userId) {
		User user = repository.findById(userId);
		if(user == null){
			throw new UserNotFoundException("User not found with id="+userId);
		}
		return user;
	}

	@Transactional
	@Override
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if(existing != null){
			throw new UserAlreadyExistException("User Already Exists with this email" + user.getEmail());
		}
		return repository.create(user);
	}

	@Transactional
	@Override
	public User update(String userId, User user) {
		User existing = repository.findById(userId);
		if(existing == null){
			throw new UserNotFoundException("User not found with id="+userId);
		}
		return repository.update(user);
	}

	@Transactional
	@Override
	public void remove(String userId) {		
		User existing = repository.findById(userId);
		if(existing == null){
			throw new UserNotFoundException("User not found with id="+userId);
		}
		repository.delete(existing);
	}

}
