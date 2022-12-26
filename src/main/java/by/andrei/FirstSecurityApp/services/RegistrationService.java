package by.andrei.FirstSecurityApp.services;

import by.andrei.FirstSecurityApp.models.Person;
import by.andrei.FirstSecurityApp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
@Autowired
    public RegistrationService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
    this.passwordEncoder = passwordEncoder;
}

    public void save(Person person) {
    person.setPassword(passwordEncoder.encode(person.getPassword()));
    person.setRole("ROLE_USER");
    personRepository.save(person);
    }
}
