package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.enums.Role;
import ua.alex.project.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


/**
 * Description : simple registration of user and validation of inputted data;
 */
public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(Attributes.REQUEST_LOGIN);
        String password = request.getParameter(Attributes.REQUEST_PASSWORD);
        String email = request.getParameter(Attributes.REQUEST_EMAIL);

        String returnPage = Attributes.PAGE_REGISTRATION;

        boolean loginRegisterError;
        boolean passwordRegisterError;
        boolean emailRegisterError;
        boolean userExistError;

        Optional<User> userByLogin = USER_SERVICE.getUserByLogin(login);


        if ( (loginRegisterError = (login == null || login.equals("") || !login.matches(Attributes.REGEX_LOGIN)))
                | (passwordRegisterError = (password == null || password.equals("") || !password.matches(Attributes.REGEX_PASSWORD)))
                | (emailRegisterError = (email == null || email.equals("")) || !email.matches(Attributes.REGEX_EMAIL))
                | (userExistError = userByLogin.isPresent())) {
            request.getSession().setAttribute(Attributes.REQUEST_LOGIN_REGISTER_ERROR, loginRegisterError);
            request.getSession().setAttribute(Attributes.REQUEST_PASSWORD_REGISTER_ERROR, passwordRegisterError);
            request.getSession().setAttribute(Attributes.REQUEST_EMAIL_REGISTER_ERROR, emailRegisterError);
            request.getSession().setAttribute(Attributes.REQUEST_USER_EXIST_ERROR, userExistError);
            LOGGER.info(this.getClass().getSimpleName() + " - registration error : " + "Login : " + login + "; email : " + email);
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
