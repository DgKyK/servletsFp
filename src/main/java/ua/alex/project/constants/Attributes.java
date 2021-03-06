package ua.alex.project.constants;

/**
 * This is the list of all Attributes;
 */
public interface Attributes {
    String CONTENT_TYPE = "text/html";
    String CHARACTER_ENCODING = "UTF-8";

    String DB_PROPERTIES_NAME = "db";
    String DB_USERNAME = "db.username";
    String DB_PASSWORD = "db.password";
    String DB_URL = "db.url";

    int RECORDS_PER_PAGE = 10;

    String DB_SQL_ALL_USERS = "sql.usersFindAll";
    String DB_SQL_SAVE_USER = "sql.usersSave";
    String DB_SQL_SAVE_STUDENT_SUCCESS = "sql.studentSuccessSave";
    String DB_SQL_FIND_USER_BY_LOGIN = "sql.usersFindByLogin";
    String DB_SQL_FIND_USER_BY_ID = "sql.usersFindById";
    String DB_SQL_ALL_TESTS = "sql.testsFindAll";
    String DB_SQL_FIND_TEST_BY_ID = "sql.testsFindById";
    String DB_SQL_FIND_ALL_QUESTIONS_BY_TEST_ID = "sql.questionsFindAllQuestionsByTestId";
    String DB_SQL_FIND_ALL_SUCCESS_BY_USER_ID = "sql.studentSuccessFindAllByUserId";
    String DB_SQL_FIND_TEST_BY_NAME = "sql.testsFindTestByName";
    String DB_SQL_UPDATE_USER = "sql.usersUpdateUser";
    String DB_SQL_FIND_LIMIT_VIEW_BY_USER_ID = "sql.successFindLimitViewByUserId";
    String DB_SQL_GET_SUCCES_COUNT_BY_USER_ID = "sql.successGetRowsCountByUserId";


    String REQUEST_LOGIN = "login";
    String REQUEST_PASSWORD = "password";
    String REQUEST_USER = "user";
    String REQUEST_EMAIL = "email";
    String REQUEST_ROLE = "role";
    String REQUEST_All_USERS = "allUsers";
    String REQUEST_ALL_TESTS = "allTests";
    String REQUEST_LOCALE_LANGUEDE = "localeLang";
    String REQUEST_NO_TESTS = "noTest";
    String REQUEST_CHOSEN_TEST = "chosenTest";
    String REQUEST_SUCCESS = "success";
    String REQUEST_USER_ID = "userId";
    String REQUEST_EDIT_USER = "editUser";
    String REQUEST_ALL_ROLES = "roles";
    String REQUEST_NEW_USER_LOGIN = "newLogin";
    String REQUEST_NEW_USER_EMAIL = "newEmail";
    String REQUEST_NEW_USER_ROLE = "newRole";
    String REQUEST_GENERAL_STATISTIC = "generalStatistic";
    String REQUEST_LOGIN_ERROR = "loginError";
    String REQUEST_LOGIN_REGISTER_ERROR = "loginRegisterError";
    String REQUEST_PASSWORD_REGISTER_ERROR = "passwordRegisterError";
    String REQUEST_EMAIL_REGISTER_ERROR = "emailRegisterError";
    String REQUEST_USER_EXIST_ERROR = "userExistError";
    String REQUEST_SESSION_LOCALE = "sessionLocale";
    String REQUEST_DOUBLE_AUTH_ERROR = "doubleAuthError";
    String REQUEST_CURRENT_PAGE = "currentPage";
    String REQUEST_NUMBER_OF_PAGES = "noOfPages";
    String REQUEST_RECORDS_PER_PAGE = "recordsPerPage";
    String REQUEST_CHECKED_TEST = "checkedTest";

    String PAGE_LOGIN = "/login.jsp";
    String PAGE_LOGIN_FIRST = "/login.jsp";
    String PAGE_LOGIN_FIRST_REDIRECT = "redirect:/loginFirst";
    String PAGE_LOGIN_REDIRECT = "redirect:/login.jsp";
    String PAGE_LOGOUT = "redirect:/loginFirst";
    String PAGE_DOUBLE_AUTH_ERROR = "redirect:/doubleAuthError";
    String PAGE_ADMIN_HOME = "/admin/admin_base.jsp";
    String PAGE_USER_HOME = "/user/user_base.jsp";
    String PAGE_ADMIN_HOME_REDIRECT = "redirect:/admin/admin_base";
    String PAGE_ADMIN_STATISTIC = "/admin/admin_statistic.jsp";
    String PAGE_USER_HOME_REDIRECT = "redirect:/user/user_base";
    String PAGE_USER_STATISTIC = "/user/user_statistic.jsp";
    String PAGE_GENERAL = "/index.jsp";
    String PAGE_REGISTRATION = "/registration.jsp";
    String PAGE_TEST = "/user/test.jsp";
    String PAGE_USER_EDITOR = "/admin/user_editor.jsp";

    String COMMAND_LOGIN = "login";
    String COMMAND_REGISTRATION_FIRST = "registrationFirst";
    String COMMAND_LOGOUT = "logout";
    String COMMAND_ADMIN_HOME = "admin_base";
    String COMMAND_USER_HOME = "user_base";
    String COMMAND_ADMIN_STATISTIC = "admin_statistic";
    String COMMAND_USER_STATISTIC = "user_statistic";
    String COMMAND_REGISTRATION = "registration";
    String COMMAND_TEST = "test";
    String COMMAND_USER_EDITOR = "user_editor";
    String COMMAND_LOGIN_FIRST = "loginFirst";
    String COMMAND_DOUBLE_AUTH_ERROR = "doubleAuthError";

    String REGEX_LOGIN = "[^_\\\\.&,#@!\\\\?\\\\(\\\\)\\\\-\\\\=\\\\+\\\\\\\\`\\\\~\\\\s][A-za-z]{1,5}[A-Za-z0-9_]{0,15}";
    String REGEX_PASSWORD = ".{4,15}";
    String REGEX_EMAIL = "\\w{2,}@[a-z]{3,}\\.[a-z]{2,}";

}
