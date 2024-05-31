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
        championshipRepository.deleteById(id);
    }

    @Override
    public List<Championship> findAll() {
        return (List<Championship>) championshipRepository.findAll();
    }

    @Override
    public Optional<Championship> findById(Integer id) {
        return championshipRepository.findById(id);
    }

    @Override
    public void save(Championship championship) {
        championshipRepository.save(championship);
    }
}
