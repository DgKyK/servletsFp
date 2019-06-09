package ua.alex.project.controller.commands;

import javax.servlet.http.HttpServletRequest;

public class User implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/user/user_base.jsp";
    }
}
