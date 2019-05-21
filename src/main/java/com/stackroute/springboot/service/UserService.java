package com.stackroute.springboot.service;

import com.stackroute.springboot.domain.User;
import com.stackroute.springboot.exceptions.UserAlreadyExistException;

import java.util.List;

public interface UserService {
    public User saveUser(User user) throws UserAlreadyExistException;
    public List<User> getAllUsers();

}
