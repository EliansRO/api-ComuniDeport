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
        // TODO Auto-generated method stub
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        userRepository.save(user);
    }
}
