package com.comunideport.rest.Service.Impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.comunideport.rest.Entities.User;
import com.comunideport.rest.Persistence.IUserDAO;
import com.comunideport.rest.Service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO iUserDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void deleteById(Integer id) {
        iUserDAO.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return iUserDAO.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return iUserDAO.findById(id);
    }

    @Override
    public void save(User user) {
        iUserDAO.save(user);
    }
}
