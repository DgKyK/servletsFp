package ua.alex.project.controller.commands;

import javax.servlet.http.HttpServletRequest;

public class AdminStatistic implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/admin/admin_statistic.jsp";
    }
}
