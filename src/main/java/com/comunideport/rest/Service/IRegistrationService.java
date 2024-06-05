package com.comunideport.rest.Service;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.Registration;

public interface IRegistrationService {

    List<Registration> findAll();

    Optional<Registration> findById(Integer id);

    void save(Registration registration);

    void deleteById(Integer id);
}
