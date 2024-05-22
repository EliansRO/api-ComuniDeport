package com.comunideport.rest.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.Championship;

@Repository
public interface ChampionshipRepository extends CrudRepository<Championship, Integer> {
}
