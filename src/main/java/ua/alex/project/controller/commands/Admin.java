package ua.alex.project.controller.commands;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.User;
import ua.alex.project.model.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * Description : command that handle Admin home page;
 */

public class Admin implements Command{


    @Override
    public String execute(HttpServletRequest request) {
        String userId = request.getParameter(Attributes.REQUEST_USER_ID);
        if(userId != null){
            saveEditedUser(request,userId);
        }
        List<User> allUsers = USER_SERVICE.getAllUsers();
        request.getSession().setAttribute(Attributes.REQUEST_All_USERS, allUsers);
        return Attributes.PAGE_ADMIN_HOME;
    }

    private void saveEditedUser(HttpServletRequest request, String userId) {
        Optional<User> userById = USER_SERVICE.getUserById(Long.parseLong(userId));

        String newLogin = request.getParameter(Attributes.REQUEST_NEW_USER_LOGIN);
        String newEmail = request.getParameter(Attributes.REQUEST_NEW_USER_EMAIL);
        System.out.println(request.getParameter(Attributes.REQUEST_NEW_USER_ROLE));
        Role newRole = Role.valueOf(request.getParameter(Attributes.REQUEST_NEW_USER_ROLE));

        User newUser = userById.get();
        newUser.setEmail(newEmail);
        newUser.setLogin(newLogin);
        newUser.setRole(newRole);

        USER_SERVICE.updateUserInfo(newUser);
    }
}
