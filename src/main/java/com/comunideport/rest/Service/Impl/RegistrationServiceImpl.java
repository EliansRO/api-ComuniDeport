package com.comunideport.rest.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunideport.rest.Entities.Registration;
import com.comunideport.rest.Persistence.IRegistrationDAO;
import com.comunideport.rest.Service.IRegistrationService;

@Service
public class RegistrationServiceImpl implements IRegistrationService {

    @Autowired
    private IRegistrationDAO iRegistrationDAO;

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        iRegistrationDAO.deleteById(id);
    }

    @Override
    public List<Registration> findAll() {
        // TODO Auto-generated method stub
        return iRegistrationDAO.findAll();
    }

    @Override
    public Optional<Registration> findById(Integer id) {
        // TODO Auto-generated method stub
        return iRegistrationDAO.findById(id);
    }

    @Override
    public void save(Registration registration) {
        // TODO Auto-generated method stub
        iRegistrationDAO.save(registration);
    }
}
