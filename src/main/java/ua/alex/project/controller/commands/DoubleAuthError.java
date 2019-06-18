package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;

import javax.servlet.http.HttpServletRequest;



/**
 * Description : command that responsible for double authentication case;
 */
public class DoubleAuthError implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute(Attributes.REQUEST_DOUBLE_AUTH_ERROR, true);
        return Attributes.PAGE_LOGIN;
    }
}
