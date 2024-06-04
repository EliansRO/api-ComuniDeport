package com.comunideport.rest.Persistence.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comunideport.rest.Entities.Registration;
import com.comunideport.rest.Persistence.IRegistrationDAO;
import com.comunideport.rest.Repository.RegistrationRepository;

@Component
public class RegistrationDAOImpl implements IRegistrationDAO {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public void deleteById(Integer id) {
        registrationRepository.deleteById(id);
    }

    @Override
    public List<Registration> findAll() {
        return (List<Registration>) registrationRepository.findAll();
    }

    @Override
    public Optional<Registration> findById(Integer id) {
        return registrationRepository.findById(id);
    }

    @Override
    public void save(Registration registration) {
        registrationRepository.save(registration);
    }

    
}
