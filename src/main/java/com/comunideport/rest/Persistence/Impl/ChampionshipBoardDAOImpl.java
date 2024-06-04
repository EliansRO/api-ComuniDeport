package com.comunideport.rest.Persistence.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comunideport.rest.Entities.ChampionshipBoard;
import com.comunideport.rest.Persistence.IChampionshipBoardDAO;
import com.comunideport.rest.Repository.ChampionshipBoardRepository;

@Component
public class ChampionshipBoardDAOImpl implements IChampionshipBoardDAO {

    @Autowired
    private ChampionshipBoardRepository championshipBoardRepository;

    @Override
    public void deleteById(Integer id) {
        championshipBoardRepository.deleteById(id);
    }

    @Override
    public List<ChampionshipBoard> findAll() {
        return (List<ChampionshipBoard>) championshipBoardRepository.findAll();
    }

    @Override
    public Optional<ChampionshipBoard> findById(Integer id) {
        return championshipBoardRepository.findById(id);
    }

    @Override
    public void save(ChampionshipBoard championshipBoard) {
        championshipBoardRepository.save(championshipBoard);
    }
}
