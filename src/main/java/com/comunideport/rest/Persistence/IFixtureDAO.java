package com.comunideport.rest.Persistence;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.Fixture;

public interface IFixtureDAO {
    List<Fixture> findAll();
    
    Optional<Fixture> findById(Integer id);

    void save(Fixture fixture);

    void deleteById(Integer id);
}
