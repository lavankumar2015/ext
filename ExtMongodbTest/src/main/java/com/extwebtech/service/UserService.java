package com.extwebtech.service;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extwebtech.bean.User;
import com.extwebtech.repository.UserRepository;
import com.mongodb.client.result.UpdateResult;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Object saveUser(User user) {
	  return userRepository.createUser(user);
	}

	public User getUser(String id) {
		return userRepository.getUser(id);
	}

	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	public String deleteUser(String id) {
		userRepository.deleteUser(id);
		return  "user deleted";
	}
	
	public UpdateResult updateUser(String id,User user) {
		return userRepository.updateUser(id,user);
	}
}
