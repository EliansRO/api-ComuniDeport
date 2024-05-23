package com.comunideport.rest.Persistence.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comunideport.rest.Entities.Championship;
import com.comunideport.rest.Persistence.IChampionshipDAO;
import com.comunideport.rest.Repository.ChampionshipRepository;

@Component
public class ChampionshipDAOImpl implements IChampionshipDAO {

    @Autowired
    private ChampionshipRepository championshipRepository;

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        championshipRepository.deleteById(id);
    }

    @Override
    public List<Championship> findAll() {
        // TODO Auto-generated method stub
        return (List<Championship>) championshipRepository.findAll();
    }

    @Override
    public Optional<Championship> findById(Integer id) {
        // TODO Auto-generated method stub
        return championshipRepository.findById(id);
    }

    @Override
    public void save(Championship championship) {
        // TODO Auto-generated method stub
        championshipRepository.save(championship);
    }
}
