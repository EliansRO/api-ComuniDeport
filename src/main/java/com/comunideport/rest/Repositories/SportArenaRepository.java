package com.comunideport.rest.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.SportArena;

@Repository
public interface SportArenaRepository extends CrudRepository<SportArena, Integer>{
}
