package ua.alex.project.controller.servlet.context;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.Test;
import ua.alex.project.model.service.impl.TestServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
@WebListener
public class ServletContext implements ServletContextListener {
    private HashSet<String> allUsers = new HashSet<>();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute(Attributes.REQUEST_All_USERS, allUsers);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        allUsers = null;
    }
}
