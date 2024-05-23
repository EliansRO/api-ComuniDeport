package com.comunideport.rest.Service.Impl;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunideport.rest.Entities.SportArena;
import com.comunideport.rest.Persistence.ISportArenaDAO;
import com.comunideport.rest.Service.ISportArenaService;

@Service
public class SportArenaServiceImpl implements ISportArenaService {

    @Autowired
    private ISportArenaDAO iSportArenaDAO;

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        iSportArenaDAO.deleteById(id);
    }

    @Override
    public List<SportArena> findAll() {
        // TODO Auto-generated method stub
        return iSportArenaDAO.findAll();
    }

    @Override
    public List<SportArena> findByHoursInRange(LocalTime minHours, LocalTime maxHours) {
        // TODO Auto-generated method stub
        return iSportArenaDAO.findByHoursInRange(minHours, maxHours);
    }

    @Override
    public Optional<SportArena> findById(Integer id) {
        // TODO Auto-generated method stub
        return iSportArenaDAO.findById(id);
    }

    @Override
    public void save(SportArena sportArena) {
        // TODO Auto-generated method stub
        iSportArenaDAO.save(sportArena);
    }
}
