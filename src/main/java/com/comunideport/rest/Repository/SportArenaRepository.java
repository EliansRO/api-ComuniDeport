package com.comunideport.rest.Repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.SportArena;

@Repository
public interface SportArenaRepository extends CrudRepository<SportArena, Integer>{

    List<SportArena> findByHoursBetweenSportArenas(LocalTime minHours, LocalTime maxHours);
}
