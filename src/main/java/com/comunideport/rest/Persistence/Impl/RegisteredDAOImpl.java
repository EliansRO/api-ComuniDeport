package com.comunideport.rest.Persistence.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comunideport.rest.Entities.Registered;
import com.comunideport.rest.Persistence.IRegisteredDAO;
import com.comunideport.rest.Repository.RegisteredRepository;

@Component
public class RegisteredDAOImpl implements IRegisteredDAO {

    @Autowired
    private RegisteredRepository registeredRepository;

    @Override
    public void deleteById(Integer id) {
        registeredRepository.deleteById(id);
    }

    @Override
    public List<Registered> findAll() {
        return (List<Registered>) registeredRepository.findAll();
    }

    @Override
    public Optional<Registered> findById(Integer id) {
        return registeredRepository.findById(id);
    }

    @Override
    public void save(Registered registered) {
        registeredRepository.save(registered);
    }
}
