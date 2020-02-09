package com.portal.procucev.service;

import java.util.List;

import com.portal.procucev.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	void delete(long id);
}
