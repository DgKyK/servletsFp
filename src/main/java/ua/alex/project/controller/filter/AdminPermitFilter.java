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
@WebFilter(urlPatterns = {/*"/admin/admin_base", "/admin/admin_statistic",*/ "/admin/*"})
public class AdminPermitFilter extends AbstractFilter {
    @Override
    protected void filter(HttpServletRequest request,
                          HttpServletResponse response,
                          FilterChain filterChain, Optional<User> user) throws ServletException, IOException {

        if (user.isPresent()) {
            if(user.get().getRole().equals(Role.ADMIN)) {
                filterChain.doFilter(request, response);
            } else if(user.get().getRole().equals(Role.USER)) {
                //TODO logging this situation
                response.sendRedirect(Attributes.PAGE_USER_HOME_REDIRECT);
            }
        } else {
            request.getRequestDispatcher(Attributes.PAGE_LOGOUT).forward(request,response);
        }

    }
}
