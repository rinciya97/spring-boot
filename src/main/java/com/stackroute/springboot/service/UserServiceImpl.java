package com.stackroute.springboot.service;

import com.stackroute.springboot.domain.User;
import com.stackroute.springboot.exceptions.UserAlreadyExistException;
import com.stackroute.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAlreadyExistException {
        if(userRepository.existsById(user.getId()))
        {
            throw new UserAlreadyExistException("user already exists exception");
        }

        User savedUser=userRepository.save(user);
        if(savedUser==null)
        {
            throw new UserAlreadyExistException("user already exist exception");
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
