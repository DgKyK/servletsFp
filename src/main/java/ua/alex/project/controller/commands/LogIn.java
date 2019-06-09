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
        String returnPage = Attributes.PAGE_LOGIN_OR_REGISTER;

        Optional<User> userFromBd = USER_SERVICE.getUserByLogin(login);

        if(userFromBd.isPresent() && userFromBd.get().getPassword().equals(password)) {
            returnPage = CommandsUtil.openUserSession(request,userFromBd.get());
        }

        return returnPage;
        /*if(login == null || login.equals("") || password == null || password.equals("")) {
            return "/login.jsp";
        } else if(login.equals("admin") && password.equals("123")) {
            return "/admin/admin_base.jsp";

        } else if(login.equals("user") && password.equals("321")) {
            return "/user/user_base.jsp";
        } else {
            return "/login.jsp";
        }*/

    }
}
