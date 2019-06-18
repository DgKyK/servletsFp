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
 * Filter that allows full access for concrete url;
 */
@WebFilter(urlPatterns = {"/login", "/registration", "/index"})
public class PermitAllFilter extends AbstractFilter {
    @Override
    protected void filter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Optional<User> user) throws ServletException, IOException {

        if(!user.isPresent()) {
            filterChain.doFilter(request,response);
        } else if(user.get().getRole().equals(Role.ADMIN)) {
            response.sendRedirect(Attributes.PAGE_ADMIN_HOME_REDIRECT);
        } else if(user.get().getRole().equals(Role.USER)) {
            response.sendRedirect(Attributes.PAGE_USER_HOME_REDIRECT);
        }
    }
}
