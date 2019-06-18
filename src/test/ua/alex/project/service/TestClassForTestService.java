package ua.alex.project.service;

import org.junit.Before;
import org.junit.Test;
import ua.alex.project.controller.exception.DataNotFoundException;
import ua.alex.project.model.service.impl.TestServiceImpl;

public class TestClassForTestService {

    private TestServiceImpl testService;


    //@Rule
    //public ExpectedException expectedException = ExpectedException.none();

    private String name;

    @Before
    public void setUp() {
        name = "alex";
        testService = new TestServiceImpl();
    }


    @Test(expected = DataNotFoundException.class)
    public void testFindTestByNameException() {

        ua.alex.project.model.entity.Test testByName = testService.findTestByName(name);

    }

}
