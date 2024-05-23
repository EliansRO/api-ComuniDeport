package com.comunideport.rest.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunideport.rest.Entities.Championship;
import com.comunideport.rest.Persistence.IChampionshipDAO;
import com.comunideport.rest.Service.IChampionshipService;

@Service
public class ChampionshipServiceImpl implements IChampionshipService{
    
    @Autowired
    private IChampionshipDAO iChampionshipDAO;

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        iChampionshipDAO.deleteById(id);
    }

    @Override
    public List<Championship> findAll() {
        // TODO Auto-generated method stub
        return iChampionshipDAO.findAll();
    }

    @Override
    public Optional<Championship> findById(Integer id) {
        // TODO Auto-generated method stub
        return iChampionshipDAO.findById(id);
    }

    @Override
    public void save(Championship championship) {
        // TODO Auto-generated method stub
        iChampionshipDAO.save(championship);
    }
}
