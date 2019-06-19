package ua.alex.project.controller.filter;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Filter for type and encoding of displaying information;
 */
@WebFilter(urlPatterns = "/")
public class EncodingFilter extends AbstractFilter{

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    protected void filter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Optional<User> user) throws ServletException, IOException {
        response.setContentType(Attributes.CONTENT_TYPE);
        response.setCharacterEncoding(Attributes.CHARACTER_ENCODING);
        request.setCharacterEncoding(Attributes.CHARACTER_ENCODING);


        filterChain.doFilter(request, response);
    }


}
