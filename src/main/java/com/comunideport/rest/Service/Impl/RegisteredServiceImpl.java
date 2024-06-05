package com.comunideport.rest.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunideport.rest.Entities.Registered;
import com.comunideport.rest.Persistence.IRegisteredDAO;
import com.comunideport.rest.Service.IRegisteredService;

@Service
public class RegisteredServiceImpl implements IRegisteredService {

    @Autowired
    private IRegisteredDAO iRegisteredDAO;

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        iRegisteredDAO.deleteById(id);
    }

    @Override
    public List<Registered> findAll() {
        // TODO Auto-generated method stub
        return iRegisteredDAO.findAll();
    }

    @Override
    public Optional<Registered> findById(Integer id) {
        // TODO Auto-generated method stub
        return iRegisteredDAO.findById(id);
    }

    @Override
    public void save(Registered registered) {
        // TODO Auto-generated method stub
        iRegisteredDAO.save(registered);
    }
}
