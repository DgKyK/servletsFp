package ua.alex.project.model.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.alex.project.model.dao.DaoFactory;
import ua.alex.project.model.dao.UserDao;
import ua.alex.project.model.entity.User;
import ua.alex.project.model.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private Logger logger = LogManager.getLogger(getClass());

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public Optional<User> getUserById(long id) {
        try(UserDao userDao = daoFactory.createUserDao()) {
            Optional<User> userFromDb = userDao.findById(id);
            if(userFromDb.isPresent()) {
                return userFromDb;
            }
        }
        logger.warn("User with id : " + id + " not found");
        return Optional.empty();
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
        logger.warn("User with login : " + login + " not found");
        return Optional.empty();
    }

    @Override
    public void addUser(User user) {
        try(UserDao userDao = daoFactory.createUserDao()) {
            userDao.save(user);
        }
    }

    @Override
    public void updateUserInfo(User newUser) {
        try(UserDao userDao = daoFactory.createUserDao()) {
            userDao.updateUser(newUser);
        }
    }
}
