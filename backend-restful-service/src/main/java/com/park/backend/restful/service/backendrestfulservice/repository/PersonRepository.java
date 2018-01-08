package com.park.backend.restful.service.backendrestfulservice.repository;

import com.park.backend.restful.service.backendrestfulservice.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
    Person findByUsername(String username);
}
