package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;
import ua.alex.project.controller.commands.util.CommandsUtil;
import ua.alex.project.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute(Attributes.REQUEST_USER);
        CommandsUtil.removeUserFromContext(request, currentUser.getLogin());

        request.getSession().setAttribute(Attributes.REQUEST_USER, null);

        return Attributes.PAGE_LOGOUT;
    }
}
