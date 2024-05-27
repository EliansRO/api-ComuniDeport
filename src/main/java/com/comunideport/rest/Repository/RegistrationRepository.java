package com.comunideport.rest.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.Registration;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration,Integer>{
}
