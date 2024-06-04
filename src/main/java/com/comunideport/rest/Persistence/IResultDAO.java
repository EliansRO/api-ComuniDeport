package com.comunideport.rest.Persistence;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.Result;

public interface IResultDAO {
    List<Result> findAll();
    
    Optional<Result> findById(Integer id);

    void save(Result result);

    void deleteById(Integer id);
}
