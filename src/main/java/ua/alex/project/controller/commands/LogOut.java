package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;
import ua.alex.project.controller.commands.util.CommandsUtil;
import ua.alex.project.model.entity.User;

import javax.servlet.http.HttpServletRequest;


/**
 * Description : command that responsible user logUot and destroy info about him from from context and session;
 */
public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute(Attributes.REQUEST_USER);
        if(currentUser != null){
            CommandsUtil.removeUserFromContext(request, currentUser.getLogin());
            request.getSession().setAttribute(Attributes.REQUEST_USER, null);
        }

        return Attributes.PAGE_LOGOUT;
    }
}
