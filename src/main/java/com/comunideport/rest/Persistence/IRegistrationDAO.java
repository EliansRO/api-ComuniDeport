package com.comunideport.rest.Persistence;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.Registration;

public interface IRegistrationDAO {
    List<Registration> findAll();
    
    Optional<Registration> findById(Integer id);

    void save(Registration registration);

    void deleteById(Integer id);
}
