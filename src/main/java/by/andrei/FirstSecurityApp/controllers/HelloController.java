package by.andrei.FirstSecurityApp.controllers;

import by.andrei.FirstSecurityApp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    public HelloController(AdminService adminService) {
        this.adminService = adminService;
    }

    private final AdminService adminService;

    @GetMapping("/hi")
    public String sayHello(){
return "hello/hi";
    }
    @GetMapping("/admin")
    public String goToPageAdmin(){
        adminService.doAdminStuff();
        return "hello/admin";
    }
}
