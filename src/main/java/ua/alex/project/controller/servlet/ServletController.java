package ua.alex.project.controller.servlet;

import ua.alex.project.controller.commands.Command;
import ua.alex.project.controller.commands.util.CommandsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Main servletController that manage all processes of program;
 */
public class ServletController extends javax.servlet.http.HttpServlet {
    private Map<String, Command> commands;

    public void init() {
        commands = CommandsUtil.getCommandsMapInit();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        processRequest(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        //System.out.println(path);
        path = path.replaceAll(".*/" , "");
        path = path.replaceAll(".*/" , "");
        //System.out.println(path);
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp");
        String page = command.execute(request);
        //System.out.println(page);
        if(page.contains("redirect")){
            response.sendRedirect(page.replace("redirect:", "/api"));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
