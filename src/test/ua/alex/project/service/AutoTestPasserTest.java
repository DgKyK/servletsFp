package ua.alex.project.service;

import org.junit.Assert;
import org.junit.Test;
import ua.alex.project.model.service.impl.AutoTestPasser;

public class AutoTestPasserTest {

    @Test
    public void getPassedTest() {
        int questionNumber = 20;
        AutoTestPasser.getPassedTest(questionNumber);
        Assert.assertEquals(questionNumber, AutoTestPasser.getPassedTest(questionNumber).size());
    }
}