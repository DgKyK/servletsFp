package ua.alex.project.model.service.impl;

import ua.alex.project.model.dao.DaoFactory;
import ua.alex.project.model.dao.UserDao;
import ua.alex.project.model.entity.User;
import ua.alex.project.model.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public User getUserById(long id) {
        try(UserDao userDao = daoFactory.createUserDao()) {
            Optional<User> userFromDb = userDao.findById(id);
            if(userFromDb.isPresent()) {
                return userFromDb.get();
            }
        }
        throw new RuntimeException("User with id : " + id + " not found");
    }

    @Override
    public List<User> getAllUsers() {
        try(UserDao userDao = daoFactory.createUserDao()) {
            return userDao.findAll();
        }

    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        try(UserDao userDao = daoFactory.createUserDao()) {
            Optional<User> userFromDb = userDao.findByLogin(login);
            if(userFromDb.isPresent()) {
                return userFromDb;
            }
        }
        return Optional.empty();
    }
}
