package com.comunideport.rest.Persistence.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comunideport.rest.Entities.User;
import com.comunideport.rest.Persistence.IUserDAO;
import com.comunideport.rest.Repository.UserRepository;

@Component
public class UserDAOImpl implements IUserDAO{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
