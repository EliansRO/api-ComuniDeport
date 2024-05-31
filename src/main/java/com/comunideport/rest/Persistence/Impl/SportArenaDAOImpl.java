package com.comunideport.rest.Persistence.Impl;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comunideport.rest.Entities.SportArena;
import com.comunideport.rest.Persistence.ISportArenaDAO;
import com.comunideport.rest.Repository.SportArenaRepository;

@Component
public class SportArenaDAOImpl implements ISportArenaDAO{
    
    @Autowired
    private SportArenaRepository sportArenaRepository;

    @Override
    public void deleteById(Integer id) {
        sportArenaRepository.deleteById(id);
    }

    @Override
    public List<SportArena> findAll() {
        return (List<SportArena>) sportArenaRepository.findAll();
    }

    @Override
    public List<SportArena> findByHoursInRange(LocalTime minHours, LocalTime maxHours) {
        return (List<SportArena>) sportArenaRepository.findByHoursBetweenSportArenas(minHours, maxHours);
    }

    @Override
    public Optional<SportArena> findById(Integer id) {
        return sportArenaRepository.findById(id);
    }

    @Override
    public void save(SportArena sportArena) {
        sportArenaRepository.save(sportArena);
    }
}
