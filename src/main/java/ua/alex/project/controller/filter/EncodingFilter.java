package ua.alex.project.controller.filter;

import ua.alex.project.constants.Attributes;

import javax.servlet.*;
import java.io.IOException;


public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType(Attributes.CONTENT_TYPE);
        servletResponse.setCharacterEncoding(Attributes.CHARACTER_ENCODING);
        servletRequest.setCharacterEncoding(Attributes.CHARACTER_ENCODING);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
