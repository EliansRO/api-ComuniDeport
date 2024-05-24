package com.comunideport.rest.Repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.SportArena;

@Repository
public interface SportArenaRepository extends CrudRepository<SportArena, Integer>{

    @Query("SELECT p FROM SportArena p WHERE p.hours >=?1 AND p.hours <=?2")
    List<SportArena> findByHoursBetweenSportArenas(LocalTime minHours, LocalTime maxHours);
}
