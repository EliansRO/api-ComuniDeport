package com.comunideport.rest.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunideport.rest.Entities.User;
import com.comunideport.rest.Persistence.IUserDAO;
import com.comunideport.rest.Service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO iUserDAO;

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        iUserDAO.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return iUserDAO.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        // TODO Auto-generated method stub
        return iUserDAO.findById(id);
    }

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        iUserDAO.save(user);
    }
}
