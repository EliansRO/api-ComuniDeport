package com.comunideport.rest.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.comunideport.rest.Entities.Sport;
import com.comunideport.rest.Persistence.ISportDAO;
import com.comunideport.rest.Service.ISportService;

public class SportServiceImpl implements ISportService {

    @Autowired
    private ISportDAO iSportDAO;

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        iSportDAO.deleteById(id);
    }

    @Override
    public List<Sport> findAll() {
        // TODO Auto-generated method stub
        return iSportDAO.findAll();
    }

    @Override
    public Optional<Sport> findById(Integer id) {
        // TODO Auto-generated method stub
        return iSportDAO.findById(id);
    }

    @Override
    public void save(Sport sport) {
        // TODO Auto-generated method stub
        iSportDAO.save(sport);
    }
    
}
