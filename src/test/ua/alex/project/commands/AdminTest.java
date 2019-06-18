package ua.alex.project.commands;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.alex.project.constants.Attributes;
import ua.alex.project.controller.commands.Admin;
import ua.alex.project.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdminTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession session;




    @Test(expected = NullPointerException.class)
    public void executeTestError() {

        Admin admin = new Admin();
        when(request.getParameter(Attributes.REQUEST_USER_ID)).thenReturn(null);


        Assert.assertEquals(Attributes.PAGE_ADMIN_HOME, admin.execute(request));
    }

    @Test
    public void executeNormalTest() {
        Admin admin = new Admin();
        List<User> allUsers = new ArrayList<>();

        when(request.getParameter(Attributes.REQUEST_USER_ID)).thenReturn(null);
        when(request.getSession()).thenReturn(session);

        Assert.assertEquals(Attributes.PAGE_ADMIN_HOME, admin.execute(request));
    }




}
