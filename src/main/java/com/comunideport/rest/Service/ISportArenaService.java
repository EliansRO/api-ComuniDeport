package com.comunideport.rest.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.SportArena;

public interface ISportArenaService {
    
    List<SportArena> findAll();
    
    Optional<SportArena> findById(Integer id);

    List<SportArena> findByHoursInRange(LocalTime minHours, LocalTime maxHours);

    void save(SportArena sportArena);

    void deleteById(Integer id);
}
