package com.comunideport.rest.Service;

import java.util.List;
import java.util.Optional;

import com.comunideport.rest.Entities.Sport;

public interface ISportService {

    List<Sport> findAll();

    Optional<Sport> findById(Integer id);

    void save(Sport sport);

    void deleteById(Integer id);
}
