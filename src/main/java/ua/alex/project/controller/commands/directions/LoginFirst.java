package ua.alex.project.controller.commands.directions;

import ua.alex.project.constants.Attributes;
import ua.alex.project.controller.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class LoginFirst implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute(Attributes.REQUEST_LOGIN_ERROR, false);
        return Attributes.PAGE_LOGIN_FIRST;
    }
}
