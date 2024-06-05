package com.comunideport.rest.Service;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.Fixture;

public interface IFixtureService {

    List<Fixture> findAll();

    Optional<Fixture> findById(Integer id);

    void save(Fixture fixture);

    void deleteById(Integer id);
}
