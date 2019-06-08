package ua.alex.project.command;

import javax.servlet.http.HttpServletRequest;

public class LogIn implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(login == null || login.equals("") || password == null || password.equals("")) {
            return "/login.jsp";
        } else if(login.equals("admin") && password.equals("123")) {
            return "redirect:/admin_base.jsp";

        } else if(login.equals("user") && password.equals("321")) {
            return "redirect:/user_base.jsp";
        } else {
            return "/login.jsp";
        }

    }
}
