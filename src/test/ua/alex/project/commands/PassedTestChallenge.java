package ua.alex.project.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.alex.project.constants.Attributes;
import ua.alex.project.controller.commands.PassedTest;
import ua.alex.project.model.entity.StudentSuccess;
import ua.alex.project.model.entity.User;
import ua.alex.project.model.service.StudentSuccessService;
import ua.alex.project.model.service.TestService;
import ua.alex.project.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PassedTestChallenge {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession session;
    private PassedTest passedTest;

    @Before
    public void setUp() {
        passedTest = new PassedTest();
    }

    @Test(expected = NullPointerException.class)
    public void executeWithError() {
        when(request.getSession()).thenReturn(session);

        passedTest.execute(request);
    }
}

