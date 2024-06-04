package com.comunideport.rest.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.Registered;

@Repository
public interface RegisteredRepository extends CrudRepository<Registered,Integer>{
}
