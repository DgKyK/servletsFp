package ua.alex.project.controller.commands;

import javax.servlet.http.HttpServletRequest;

public class Admin implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        return "/admin/admin_base.jsp";
    }
}
