package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.enums.Role;
import ua.alex.project.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(Attributes.REQUEST_LOGIN);
        String password = request.getParameter(Attributes.REQUEST_PASSWORD);
        String email = request.getParameter(Attributes.REQUEST_EMAIL);
        String returnPage = Attributes.PAGE_REGISTRATION;

        boolean loginError = false;
        boolean passwordError = false;
        boolean emailError = false;


        if ( (loginError = (login == null || login.equals("") || login.matches(Attributes.REGEX_LOGIN)))
                || (passwordError = (password == null || password.equals("") || password.matches(Attributes.REGEX_PASSWORD)))
                || (emailError = (email == null || email.equals("")) || email.matches(Attributes.REGEX_EMAIL))) {
            request.setAttribute("loginError", loginError);
            request.setAttribute("passwordError", passwordError);
            request.setAttribute("emailError", emailError);
            //TODO log.info( "registration error" )
            return returnPage;
        }
        User user = User.newBuilder()
                .setLogin(login)
                .setPassword(password)
                .setEmail(email)
                .setRole(Role.USER)
                .build();
        USER_SERVICE.addUser(user);
        returnPage = Attributes.PAGE_LOGIN_REDIRECT;


        return returnPage;
    }
}
