package ua.alex.project.controller.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.alex.project.constants.Attributes;
import ua.alex.project.controller.commands.util.CommandsUtil;
import ua.alex.project.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Description : command that responsible for user authorisation;
 */
public class LogIn implements Command {
    private Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(Attributes.REQUEST_LOGIN);
        String password = request.getParameter(Attributes.REQUEST_PASSWORD);
        String doubleAuthError = request.getParameter(Attributes.REQUEST_DOUBLE_AUTH_ERROR);
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
