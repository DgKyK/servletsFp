package ua.alex.project.controller.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.alex.project.model.dao.mapper.UserMapper;
import ua.alex.project.model.service.StudentSuccessService;
import ua.alex.project.model.service.TestService;
import ua.alex.project.model.service.UserService;
import ua.alex.project.model.service.impl.StudentSuccessServiceImpl;
import ua.alex.project.model.service.impl.TestServiceImpl;
import ua.alex.project.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Logger LOGGER = LogManager.getLogger();
    UserService USER_SERVICE = new UserServiceImpl();
    TestService TEST_SERVICE = new TestServiceImpl();
    StudentSuccessService STUDENT_SUCCESS_SERVICE = new StudentSuccessServiceImpl();
    UserMapper USER_MAPPER = new UserMapper();

    String execute(HttpServletRequest request);
}
