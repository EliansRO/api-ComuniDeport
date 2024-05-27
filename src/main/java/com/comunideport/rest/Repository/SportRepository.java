package com.comunideport.rest.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.Sport;

@Repository
public interface SportRepository extends CrudRepository<Sport,Integer>{
}
