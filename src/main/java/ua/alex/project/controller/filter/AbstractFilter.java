package ua.alex.project.controller.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public abstract class AbstractFilter implements Filter {
    protected Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Optional<User> user = Optional.ofNullable( (User) session.getAttribute(Attributes.REQUEST_USER));

        filter(request,response,filterChain, user);
    }

    @Override
    public void destroy() {

    }

    protected abstract void filter(HttpServletRequest request,
                           HttpServletResponse response,
                           FilterChain filterChain,
                           Optional<User> user) throws ServletException, IOException;
}
