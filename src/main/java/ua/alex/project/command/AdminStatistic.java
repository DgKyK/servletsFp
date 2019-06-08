package ua.alex.project.command;

import javax.servlet.http.HttpServletRequest;

public class AdminStatistic implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/admin_statistic.jsp";
    }
}
