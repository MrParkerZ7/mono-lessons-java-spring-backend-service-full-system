package com.park.backend.restful.service.backendrestfulservice.service;

import com.park.backend.restful.service.backendrestfulservice.model.CustomPersonDetails;
import com.park.backend.restful.service.backendrestfulservice.model.Person;
import com.park.backend.restful.service.backendrestfulservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustromPersonDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> optionalPerson = Optional.ofNullable(personRepository.findByUsername(username));

        optionalPerson.orElseThrow(() -> new UsernameNotFoundException("Username not found!!"));
        return optionalPerson.map(CustomPersonDetails::new).get();
    }
}
