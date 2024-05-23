package com.comunideport.rest.Service;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.Team;

public interface ITeamService {
    
    List<Team> findAll();
    
    Optional<Team> findById(Integer id);

    void save(Team team);

    void deleteById(Integer id);
}
