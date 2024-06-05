package com.comunideport.rest.Service;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.Registered;

public interface IRegisteredService {

    List<Registered> findAll();

    Optional<Registered> findById(Integer id);

    void save(Registered registered);

    void deleteById(Integer id);
}
