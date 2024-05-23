package com.comunideport.rest.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.comunideport.rest.Entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
