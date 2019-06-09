package ua.alex.project.controller.commands;

import ua.alex.project.model.dao.mapper.UserMapper;
import ua.alex.project.model.service.UserService;
import ua.alex.project.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    UserService USER_SERVICE = new UserServiceImpl();

    UserMapper USER_MAPPER = new UserMapper();

    String execute(HttpServletRequest request);
}
