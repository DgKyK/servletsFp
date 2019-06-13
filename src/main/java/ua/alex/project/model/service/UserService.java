package ua.alex.project.model.service;

import ua.alex.project.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(long id);
    List<User> getAllUsers();
    Optional<User> getUserByLogin(String login);

    void addUser(User user);

    void updateUserInfo(User newUser);
}
