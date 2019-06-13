package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;
import ua.alex.project.controller.commands.util.CommandsUtil;
import ua.alex.project.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LogIn implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(Attributes.REQUEST_LOGIN);
        String password = request.getParameter(Attributes.REQUEST_PASSWORD);
        String returnPage = Attributes.PAGE_LOGIN;
        Optional<User> userFromBd = USER_SERVICE.getUserByLogin(login);

        if(userFromBd.isPresent() && userFromBd.get().getPassword().equals(password)) {
            returnPage = CommandsUtil.openUserSession(request,userFromBd.get());
        } else {
            request.getSession().setAttribute(Attributes.REQUEST_LOGIN_ERROR, true);
        }

        return returnPage;
    }
}
