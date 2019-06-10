package ua.alex.project.constants;

public interface Attributes {
    String CONTENT_TYPE = "text/html";
    String CHARACTER_ENCODING = "UTF-8";

    String DB_PROPERTIES_NAME = "db";
    String DB_USERNAME = "db.username";
    String DB_PASSWORD = "db.password";
    String DB_URL = "db.url";

    String DB_SQL_ALL_USERS = "sql.usersFindAll";
    String DB_SQL_SAVE = "sql.usersSave";
    String DB_SQL_FIND_BY_LOGIN = "sql.usersFindByLogin";
    String DB_SQL_FIND_BY_ID = "sql.usersFindById";


    String REQUEST_LOGIN = "login";
    String REQUEST_PASSWORD = "password";
    String REQUEST_USER = "user";
    String REQUEST_EMAIL = "email";
    String REQUEST_ROLE = "role";
    String REQUEST_All_USERS = "allUsers";
    String REQUEST_ALL_TESTS = "allTests";
    String REQUEST_LOCALE_LANGUEDE = "localeLang";

    String PAGE_LOGIN_OR_REGISTER = "/login.jsp";
    String PAGE_LOGOUT = "redirect:/login";
    String PAGE_DOUBLE_AUTH_ERROR = "redirect:/doubleAuthError";
    String PAGE_ADMIN_HOME = "/admin/admin_base";
    String PAGE_USER_HOME = "/user/user_base";
    String PAGE_ADMIN_HOME_REDIRECT = "redirect:/admin/admin_base";
    String PAGE_USER_HOME_REDIRECT = "redirect:/user/user_base";

    String COMMAND_LOGIN_OR_REGISTER = "login";
    String COMMAND_LOGOUT = "logout";
    String COMMAND_ADMIN_HOME = "admin_base";
    String COMMAND_USER_HOME = "user_base";
    String COMMAND_ADMIN_STATISTIC = "admin_statistic";
    String COMMAND_USER_STATISTIC = "user_statistic";

}
