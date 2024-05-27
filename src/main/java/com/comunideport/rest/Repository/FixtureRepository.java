package com.comunideport.rest.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.Fixture;

@Repository
public interface FixtureRepository extends CrudRepository<Fixture,Integer>{
}
