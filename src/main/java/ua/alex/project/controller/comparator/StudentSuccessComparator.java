package ua.alex.project.controller.comparator;

import ua.alex.project.model.entity.StudentSuccess;

import java.util.Comparator;

public class StudentSuccessComparator implements Comparator<StudentSuccess> {
    @Override
    public int compare(StudentSuccess o1, StudentSuccess o2) {
        if (o1.getWriteAnswer() == o2.getWriteAnswer()){
            return 0;
        } else if(o1.getWriteAnswer() > o2.getWriteAnswer()) {
            return -1;
        } else {
            return 1;
        }
    }
}
