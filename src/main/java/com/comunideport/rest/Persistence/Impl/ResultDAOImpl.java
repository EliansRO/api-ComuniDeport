package com.comunideport.rest.Persistence.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comunideport.rest.Entities.Result;
import com.comunideport.rest.Persistence.IResultDAO;
import com.comunideport.rest.Repository.ResultRepository;

@Component
public class ResultDAOImpl implements IResultDAO {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public void deleteById(Integer id) {
        resultRepository.deleteById(id);
    }

    @Override
    public List<Result> findAll() {
        return (List<Result>) resultRepository.findAll();
    }

    @Override
    public Optional<Result> findById(Integer id) {
        return resultRepository.findById(id);
    }

    @Override
    public void save(Result result) {
        resultRepository.save(result);
    }
}
