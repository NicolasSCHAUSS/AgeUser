package web.atrio.thymeleaf.service;

import java.util.List;

import web.atrio.thymeleaf.model.User;

public interface UserService {
    public List<User> getAllUsers();
    public void addUser(User u);
}
