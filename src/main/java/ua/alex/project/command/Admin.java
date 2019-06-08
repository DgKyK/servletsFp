package ua.alex.project.command;

import javax.servlet.http.HttpServletRequest;

public class Admin implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        return "/admin_base.jsp";
    }
}
