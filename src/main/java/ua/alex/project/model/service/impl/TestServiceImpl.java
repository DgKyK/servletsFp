package ua.alex.project.model.service.impl;

import ua.alex.project.model.dao.DaoFactory;
import ua.alex.project.model.dao.TestDao;
import ua.alex.project.model.entity.Test;
import ua.alex.project.model.service.TestService;

import java.util.List;
import java.util.Optional;

public class TestServiceImpl implements TestService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<Test> findAll() {
        try(TestDao testDao = daoFactory.createTestDao()) {
            return testDao.findAll();
        }
    }

    @Override
    public Test findTestById(long id) {
        try(TestDao testDao = daoFactory.createTestDao()) {
            Optional<Test> testFromDb = testDao.findById(id);
            if (testFromDb.isPresent()) {
                return testFromDb.get();
            } else {
                //TODO logging this case and add your own exception (TestNotFoundException)
                throw new RuntimeException("Test with id : " + id + "not found");
            }
        }
    }
}
