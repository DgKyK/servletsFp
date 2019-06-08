package ua.alex.project.command;

import javax.servlet.http.HttpServletRequest;

public class User implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/user_base.jsp";
    }
}
