package ua.alex.project.model.dao;

import ua.alex.project.model.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Concrete interface for UserDao with specific methods;
 */
public interface UserDao extends GenericDao<User> {
    Optional<User> findByLogin(String nickName);
    void save(User user);

    void updateUser(User newUser);
}
