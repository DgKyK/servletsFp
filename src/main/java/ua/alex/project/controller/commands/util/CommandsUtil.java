package ua.alex.project.controller.commands.util;

import ua.alex.project.constants.Attributes;
import ua.alex.project.controller.commands.*;
import ua.alex.project.model.entity.User;
import ua.alex.project.model.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CommandsUtil {


    public static Map<String, Command> getCommandsMapInit() {
        Map<String, Command> commands = new HashMap<>();
        commands.put(Attributes.COMMAND_LOGOUT, new LogOut());
        commands.put(Attributes.COMMAND_LOGIN_OR_REGISTER, new LogIn());
        commands.put(Attributes.COMMAND_ADMIN_HOME, new Admin());
        commands.put(Attributes.COMMAND_USER_HOME, new ua.alex.project.controller.commands.User());
        commands.put(Attributes.COMMAND_ADMIN_STATISTIC, new AdminStatistic());
        commands.put(Attributes.COMMAND_USER_STATISTIC, new UserStatistic());
        commands.put(Attributes.COMMAND_REGISTRATION, new Registration());
        commands.put(Attributes.COMMAND_TEST, new PassedTest());
        commands.put(Attributes.COMMAND_USER_EDITOR, new EditUser());

        return commands;
    }

    public static String openUserSession(HttpServletRequest request, User user) {

        HashSet<String> allUsers = (HashSet<String>) request.getServletContext().getAttribute(Attributes.REQUEST_All_USERS);

        if(allUsers.contains(user.getLogin())) {
            //TODO logging warn double auth
            return Attributes.PAGE_DOUBLE_AUTH_ERROR; // add such command in commands and return simple LOGIN_OR_REGISTER
        }

        request.getSession().setAttribute(Attributes.REQUEST_USER, user);

        allUsers.add(user.getLogin());
        request.getServletContext().setAttribute(Attributes.REQUEST_All_USERS, allUsers);
        //TODO logging INFO user have been logged

        if (user.getRole().equals(Role.ADMIN)) {
            return Attributes.PAGE_ADMIN_HOME_REDIRECT;
        } else if( user.getRole().equals(Role.USER)) {
            return Attributes.PAGE_USER_HOME_REDIRECT;
        } else {
            return Attributes.PAGE_LOGIN;
        }
    }

    public static void removeUserFromContext(HttpServletRequest request, String login) {
        HashSet<String> allUsers = (HashSet<String>) request.getServletContext().getAttribute(Attributes.REQUEST_All_USERS);
        allUsers.remove(login);
        request.getServletContext().setAttribute(Attributes.REQUEST_All_USERS,allUsers);
    }
}
