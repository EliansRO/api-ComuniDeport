package com.comunideport.rest.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.ChampionshipBoard;

@Repository
public interface ChampionshipBoardRepository extends CrudRepository<ChampionshipBoard,Integer>{

}
