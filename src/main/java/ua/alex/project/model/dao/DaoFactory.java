package ua.alex.project.model.dao;

import ua.alex.project.model.dao.impl.JDBCDaoFactory;

/**
 * Abstract factory pattern for DAO
 */
public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract TestDao createTestDao();
    public abstract StudentSuccessDao createStudentSuccessDao();
    public abstract QuestionDao createQuestionDao();


    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
