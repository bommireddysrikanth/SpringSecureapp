package com.secureapp.service;

import java.util.List;

import com.secureapp.model.User;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}
