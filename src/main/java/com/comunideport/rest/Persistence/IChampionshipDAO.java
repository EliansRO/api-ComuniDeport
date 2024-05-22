package com.comunideport.rest.Persistence;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.Championship;

public interface IChampionshipDAO {
    List<Championship> findAll();
    
    Optional<Championship> findById(Integer id);

    void save(Championship championship);

    void deleteById(Integer id);
}
