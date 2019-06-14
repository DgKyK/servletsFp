package ua.alex.project.controller.filter;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/*"})
public class SessionLocaleFilter extends AbstractFilter {

    @Override
    protected void filter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Optional<User> user) throws ServletException, IOException {

        if (request.getParameter(Attributes.REQUEST_SESSION_LOCALE) != null) {
            request.getSession().setAttribute("locale", request.getParameter(Attributes.REQUEST_SESSION_LOCALE));
        }

        filterChain.doFilter(request, response);
    }
}
