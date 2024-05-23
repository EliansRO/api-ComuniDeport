package com.comunideport.rest.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunideport.rest.Entities.Team;
import com.comunideport.rest.Persistence.ITeamDAO;
import com.comunideport.rest.Service.ITeamService;

@Service
public class TeamServiceImpl implements ITeamService {

    @Autowired
    private ITeamDAO iTeamDAO;

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        iTeamDAO.deleteById(id);
    }

    @Override
    public List<Team> findAll() {
        // TODO Auto-generated method stub
        return iTeamDAO.findAll();
    }

    @Override
    public Optional<Team> findById(Integer id) {
        // TODO Auto-generated method stub
        return iTeamDAO.findById(id);
    }

    @Override
    public void save(Team team) {
        // TODO Auto-generated method stub
        iTeamDAO.save(team);
    }
}
