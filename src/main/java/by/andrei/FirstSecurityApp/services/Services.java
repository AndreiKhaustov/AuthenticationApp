package by.andrei.FirstSecurityApp.services;

import by.andrei.FirstSecurityApp.models.Person;
import by.andrei.FirstSecurityApp.repositories.PersonRepository;
import by.andrei.FirstSecurityApp.security.PersonDetails;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Services implements UserDetailsService {
    private PersonRepository personRepository;
@Autowired
    public Services(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> ddd = personRepository.findByUsername(username);
        if(ddd.isEmpty()){
            throw new UsernameNotFoundException("UserNotFound");
        }
        return  new PersonDetails(ddd.get());
    }
}
