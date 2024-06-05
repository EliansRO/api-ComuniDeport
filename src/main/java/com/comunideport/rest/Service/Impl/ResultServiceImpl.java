package com.comunideport.rest.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.comunideport.rest.Entities.Result;
import com.comunideport.rest.Persistence.IResultDAO;
import com.comunideport.rest.Service.IResultService;

public class ResultServiceImpl implements IResultService {

    @Autowired
    private IResultDAO iResultDAO;

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        iResultDAO.deleteById(id);
    }

    @Override
    public List<Result> findAll() {
        // TODO Auto-generated method stub
        return iResultDAO.findAll();
    }

    @Override
    public Optional<Result> findById(Integer id) {
        // TODO Auto-generated method stub
        return iResultDAO.findById(id);
    }

    @Override
    public void save(Result result) {
        // TODO Auto-generated method stub
        iResultDAO.save(result);
    }
}
