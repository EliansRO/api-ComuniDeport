package com.comunideport.rest.Persistence.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comunideport.rest.Entities.Fixture;
import com.comunideport.rest.Persistence.IFixtureDAO;
import com.comunideport.rest.Repository.FixtureRepository;

@Component
public class FixtureDAOImpl implements IFixtureDAO {

    @Autowired
    private FixtureRepository fixtureRepository;

    @Override
    public void deleteById(Integer id) {
        fixtureRepository.deleteById(id);
    }

    @Override
    public List<Fixture> findAll() {
        return (List<Fixture>) fixtureRepository.findAll();
    }

    @Override
    public Optional<Fixture> findById(Integer id) {
        return fixtureRepository.findById(id);
    }

    @Override
    public void save(Fixture fixture) {
        fixtureRepository.save(fixture);
    }
}
