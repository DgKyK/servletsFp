package ua.alex.project.controller.listener;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.entity.User;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;
import java.util.Optional;




@WebListener
public class SessionListener implements HttpSessionListener {
    private HashSet<String> allUsers;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        allUsers = (HashSet<String>) sessionEvent.getSession().getServletContext().getAttribute(Attributes.REQUEST_All_USERS);
        Optional.ofNullable( (User) sessionEvent.getSession()
                .getAttribute(Attributes.REQUEST_USER))
                .ifPresent(x -> allUsers.remove(x.getLogin()));
        sessionEvent.getSession().getServletContext().setAttribute(Attributes.DB_SQL_ALL_USERS, allUsers);
    }
}
