package web.atrio.thymeleaf.controller;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

import web.atrio.thymeleaf.model.User;
import web.atrio.thymeleaf.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class UserController {
 
    private List<User> users = new ArrayList<User>();

    @Autowired
    private UserService userServ;
 
    @Value("${welcome.message}")
    private String message;
 
    @Value("${error.message}")
    private String errorMessage;
 
    public void addUser(User u) {
        this.users.add(u);
        this.userServ.addUser(u);
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        if(model.getAttribute("userForm")==null) {
            User userForm = new User();
            model.addAttribute("userForm", userForm);
        }

        model.addAttribute("message", message);
        model.addAttribute("users", users);
        return "index";
    }
 
    @RequestMapping(value = { "/index" }, method = RequestMethod.POST)
    public String saveUser(Model model, @ModelAttribute("userForm") User userForm) {
 
        String firstName = userForm.getFirstName();
        String lastName = userForm.getLastName();
        String birthday = userForm.getBirthdayStr();
        
        if (firstName != null && firstName.length() > 0 
            && lastName != null && lastName.length() > 0
            && birthday.length() > 0) {
            
            try{
                User newUser = new User(firstName,lastName,birthday);
                this.addUser(newUser);
                model.addAttribute("userForm", new User());
                return "redirect:/index";
            }
            catch (DateTimeException e)
            {
                model.addAttribute("errorMessage", e.getMessage());
                return index(model);
            }
        }
        else {
            model.addAttribute("errorMessage", errorMessage);
            return index(model);
        }
    }
}
