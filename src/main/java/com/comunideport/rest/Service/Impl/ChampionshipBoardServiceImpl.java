package com.comunideport.rest.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunideport.rest.Entities.ChampionshipBoard;
import com.comunideport.rest.Persistence.IChampionshipBoardDAO;
import com.comunideport.rest.Service.IChampionshipBoardService;

@Service
public class ChampionshipBoardServiceImpl implements IChampionshipBoardService {

    @Autowired
    private IChampionshipBoardDAO iChampionshipBoardDAO;

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        iChampionshipBoardDAO.deleteById(id);
    }

    @Override
    public List<ChampionshipBoard> findAll() {
        // TODO Auto-generated method stub
        return iChampionshipBoardDAO.findAll();
    }

    @Override
    public Optional<ChampionshipBoard> findById(Integer id) {
        // TODO Auto-generated method stub
        return iChampionshipBoardDAO.findById(id);
    }

    @Override
    public void save(ChampionshipBoard championshipBoard) {
        // TODO Auto-generated method stub
        iChampionshipBoardDAO.save(championshipBoard);
    }

    
}
