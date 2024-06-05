package com.comunideport.rest.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.comunideport.rest.Entities.Fixture;
import com.comunideport.rest.Persistence.IFixtureDAO;
import com.comunideport.rest.Service.IFixtureService;

public class FixtureServiceImpl implements IFixtureService {

    @Autowired
    private IFixtureDAO iFixtureDAO;

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        iFixtureDAO.deleteById(id);
    }

    @Override
    public List<Fixture> findAll() {
        // TODO Auto-generated method stub
        return iFixtureDAO.findAll();
    }

    @Override
    public Optional<Fixture> findById(Integer id) {
        // TODO Auto-generated method stub
        return iFixtureDAO.findById(id);
    }

    @Override
    public void save(Fixture fixture) {
        // TODO Auto-generated method stub
        iFixtureDAO.save(fixture);
    }
}
