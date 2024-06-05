package com.comunideport.rest.Service;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.ChampionshipBoard;

public interface IChampionshipBoardService {

    List<ChampionshipBoard> findAll();

    Optional<ChampionshipBoard> findById(Integer id);

    void save(ChampionshipBoard championshipBoard);

    void deleteById(Integer id);
}
