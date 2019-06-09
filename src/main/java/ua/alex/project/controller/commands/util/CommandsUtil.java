package ua.alex.project.controller.commands.util;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.User;
import ua.alex.project.model.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class CommandsUtil {

    public static String openUserSession(HttpServletRequest request, User user) {

        HashSet<String> allUsers = (HashSet<String>) request.getServletContext().getAttribute(Attributes.REQUEST_All_USERS);

        if(allUsers.contains(user.getLogin())) {
            //TODO logging warn double auth
            return Attributes.PAGE_DOUBLE_AUTH_ERROR;
        }

        request.getSession().setAttribute(Attributes.REQUEST_USER, user);

        allUsers.add(user.getLogin());
        request.getServletContext().setAttribute(Attributes.REQUEST_All_USERS, allUsers);
        //TODO logging INFO user have been logged

        if (user.getRole().equals(Role.ADMIN)) {
            return Attributes.PAGE_ADMIN_HOME;
        } else if( user.getRole().equals(Role.USER)) {
            return Attributes.PAGE_USER_HOME;
        } else {
            return Attributes.PAGE_LOGIN_OR_REGISTER;
        }

    }
}
