package web.atrio.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.atrio.thymeleaf.model.User;
import web.atrio.thymeleaf.service.UserService;

@RestController
public class UserRestController {
    
    @Autowired
    private UserService userServ;
    
    @RequestMapping(value = {"/users"}, method= RequestMethod.GET)
    public List<User> getUsers() {
        return this.userServ.getAllUsers();
    }
}
