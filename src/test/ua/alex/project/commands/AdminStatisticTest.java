package ua.alex.project.commands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.alex.project.constants.Attributes;
import ua.alex.project.controller.commands.AdminStatistic;
import ua.alex.project.model.service.impl.GeneralStatisticMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdminStatisticTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private GeneralStatisticMapper mapper;
    @Mock
    private HttpSession session;

    private AdminStatistic adminStatistic;

    @Before
    public void setUp() {
        adminStatistic = new AdminStatistic();
    }

    @Test
    public void testExecuteNormal() {
        when(request.getSession()).thenReturn(session);

        Assert.assertEquals(Attributes.PAGE_ADMIN_STATISTIC, adminStatistic.execute(request));
    }

    @Test(expected = NullPointerException.class)
    public void testExecuteError() {
        when(request.getSession()).thenReturn(null);

        adminStatistic.execute(request);
    }

}
