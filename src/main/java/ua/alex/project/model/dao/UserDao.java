package ua.alex.project.model.dao;

import ua.alex.project.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends GenericDao<User> {
    List<User> findAll();
    Optional<User> findByLogin(String nickName);
    void save(User user);
}
