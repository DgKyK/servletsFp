package ua.alex.project.controller.filter;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.User;
import ua.alex.project.model.enums.Role;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Filter for admin pages accessing;
 */
@WebFilter(urlPatterns = {"/admin/*", "/admin_base", "/admin_statistic", "/user_editor"})
public class AdminPermitFilter extends AbstractFilter {
    @Override
    protected void filter(HttpServletRequest request,
                          HttpServletResponse response,
                          FilterChain filterChain, Optional<User> user) throws ServletException, IOException {

        if (user.isPresent()) {
            if(user.get().getRole().equals(Role.ADMIN)) {
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", 0);
                filterChain.doFilter(request, response);
            } else if(user.get().getRole().equals(Role.USER)) {
                logger.warn("user : " + user.get().getLogin() + " try to access admin page!!!");
                response.sendRedirect(Attributes.PAGE_USER_HOME_REDIRECT);
            }
        } else {
            request.getRequestDispatcher(Attributes.PAGE_LOGOUT).forward(request,response);
        }

    }
}
