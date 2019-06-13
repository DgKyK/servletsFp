package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Admin implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        List<User> allUsers = USER_SERVICE.getAllUsers();

        request.getSession().setAttribute(Attributes.REQUEST_All_USERS, allUsers);

        return Attributes.PAGE_ADMIN_HOME;
    }
}
