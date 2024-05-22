package com.comunideport.rest.Persistence;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.Team;

public interface ITeamDAO {
    List<Team> findAll();
    
    Optional<Team> findById(Integer id);

    void save(Team team);

    void deleteById(Integer id);
}
