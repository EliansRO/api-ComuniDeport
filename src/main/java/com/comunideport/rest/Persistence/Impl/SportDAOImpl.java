package com.comunideport.rest.Persistence.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comunideport.rest.Entities.Sport;
import com.comunideport.rest.Persistence.ISportDAO;
import com.comunideport.rest.Repository.SportRepository;

@Component
public class SportDAOImpl implements ISportDAO {

    @Autowired
    private SportRepository sportRepository;

    @Override
    public void deleteById(Integer id) {
        sportRepository.deleteById(id);
    }

    @Override
    public List<Sport> findAll() {
        return (List<Sport>) sportRepository.findAll();
    }

    @Override
    public Optional<Sport> findById(Integer id) {
        return sportRepository.findById(id);
    }

    @Override
    public void save(Sport sport) {
        sportRepository.save(sport);
    }
}
