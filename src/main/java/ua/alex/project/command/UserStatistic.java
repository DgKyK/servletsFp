package ua.alex.project.command;

import javax.servlet.http.HttpServletRequest;

public class UserStatistic implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/user_statistic.jsp";
    }
}
