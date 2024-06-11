package com.comunideport.rest.Persistence;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.User;

public interface IUserDAO {
    List<User> findAll();
    
    Optional<User> findById(Integer id);

    void save(User user);

    void deleteById(Integer id);

    User findByUsername(String username);
}
