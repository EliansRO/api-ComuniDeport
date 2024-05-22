package com.comunideport.rest.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer>{
}
