package com.park.backend.restful.service.backendrestfulservice.component;

import com.park.backend.restful.service.backendrestfulservice.model.Person;
import com.park.backend.restful.service.backendrestfulservice.model.Status;
import com.park.backend.restful.service.backendrestfulservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PersonLoader implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        personRepository.deleteAll();

        List<Person> people = Arrays.asList(
                new Person("AF89EF", "User", "1234", "Park",
                        new Status(true, true, true, true),
                        Arrays.asList("USER")),
                new Person("G8A12C", "Admin", "1234", "Ark",
                        new Status(true, true, true, true),
                        Arrays.asList("ADMIN")),
                new Person("O8AD7H", "Boss", "1234", "Frank",
                        new Status(true, true, true, true),
                        Arrays.asList("USER", "ADMIN"))
        );

        personRepository.saveAll(people);
    }
}


