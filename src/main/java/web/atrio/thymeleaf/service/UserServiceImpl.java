package web.atrio.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.atrio.thymeleaf.model.User;
import web.atrio.thymeleaf.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired 
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return (List<User>)userRepository.findAll();
    }

    public void addUser(User u){
        this.userRepository.save(u);
    }
}
