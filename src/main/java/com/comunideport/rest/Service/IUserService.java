package com.comunideport.rest.Service;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.User;

public interface IUserService {
    
    List<User> findAll();
    
    Optional<User> findById(Integer id);

    void save(User user);

    void deleteById(Integer id);
}
