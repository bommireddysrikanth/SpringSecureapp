package com.portal.procucev.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.portal.procucev.model.User;
import com.portal.procucev.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> listUser() {
		return userService.findAll();
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Long id) {
		userService.delete(id);
		return "success";
	}

}