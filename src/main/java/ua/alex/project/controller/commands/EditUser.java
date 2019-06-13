package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.User;
import ua.alex.project.model.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class EditUser implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        long userId = Long.parseLong(request.getParameter(Attributes.REQUEST_USER_ID));

        System.out.println(userId);
        Optional<User> userById = USER_SERVICE.getUserById(userId);
        Role[] roles = Role.values();

        request.getSession().setAttribute(Attributes.REQUEST_EDIT_USER, userById.get());
        request.getSession().setAttribute(Attributes.REQUEST_ALL_ROLES, roles);
        return Attributes.PAGE_USER_EDITOR;
    }
}
