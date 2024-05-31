package com.comunideport.rest.Persistence.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comunideport.rest.Entities.Team;
import com.comunideport.rest.Persistence.ITeamDAO;
import com.comunideport.rest.Repository.TeamRepository;

@Component
public class TeamDAOImpl implements ITeamDAO {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void deleteById(Integer id) {
        teamRepository.deleteById(id);
    }

    @Override
    public List<Team> findAll() {
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public Optional<Team> findById(Integer id) {
        return teamRepository.findById(id);
    }

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }   
}
