package com.extwebtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extwebtech.bean.User;
import com.extwebtech.service.UserService;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public Object saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping
	public UpdateResult updateUser(@RequestParam String id,@RequestBody User user) {
		return userService.updateUser(id,user);
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable String id) {
		return userService.getUser(id);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id) {
	   return userService.deleteUser(id);
	}
}
