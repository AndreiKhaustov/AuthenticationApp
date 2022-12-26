package by.andrei.FirstSecurityApp.controllers;

import by.andrei.FirstSecurityApp.models.Person;
import by.andrei.FirstSecurityApp.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final RegistrationService registrationService;
@Autowired
    public AuthController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String getAuth(){
        return "auth/login";
    }
    @GetMapping("/registration")
    public String registerPage(@ModelAttribute("Person")Person person) {
        return "auth/registration";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerPerson(@ModelAttribute("Person") Person person) {
        registrationService.save(person);
        return "redirect:auth/login";
    }
}
