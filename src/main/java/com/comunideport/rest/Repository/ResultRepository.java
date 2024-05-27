package com.comunideport.rest.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.Result;

@Repository
public interface ResultRepository extends CrudRepository<Result,Integer>{
}
