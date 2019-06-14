package ua.alex.project.controller.commands.directions;

import ua.alex.project.constants.Attributes;
import ua.alex.project.controller.commands.Command;

import javax.servlet.http.HttpServletRequest;

public class RegistrationFirst implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute(Attributes.REQUEST_LOGIN_REGISTER_ERROR, false);
        request.getSession().setAttribute(Attributes.REQUEST_PASSWORD_REGISTER_ERROR, false);
        request.getSession().setAttribute(Attributes.REQUEST_EMAIL_REGISTER_ERROR, false);
        request.getSession().setAttribute(Attributes.REQUEST_USER_EXIST_ERROR, false);

        return Attributes.PAGE_REGISTRATION;
    }
}
