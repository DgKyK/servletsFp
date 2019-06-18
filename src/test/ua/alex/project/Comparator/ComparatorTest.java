package ua.alex.project.Comparator;

import org.junit.Assert;
import org.junit.Test;
import ua.alex.project.controller.comparator.StudentSuccessComparator;
import ua.alex.project.model.entity.StudentSuccess;

import java.util.ArrayList;
import java.util.List;

public class ComparatorTest {
    private static final int MAX_WRITE_ANSWER = 15;



    @Test
    public void testSortingByStudentSuccessComparator() {

        List<StudentSuccess> testList = new ArrayList<>();
        for (int i = 0; i <= MAX_WRITE_ANSWER; i++) {
            testList.add(new StudentSuccess.Builder()
                                    .setWriteAnswer(i).build());
        }

        testList.sort(new StudentSuccessComparator());

        Assert.assertEquals(MAX_WRITE_ANSWER, testList.get(0).getWriteAnswer());

    }
}
