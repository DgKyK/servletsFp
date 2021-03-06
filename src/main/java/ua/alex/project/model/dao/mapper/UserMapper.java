package ua.alex.project.model.dao.mapper;

import ua.alex.project.model.entity.User;
import ua.alex.project.model.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class that helps to map the User entity from DB;
 */
public class UserMapper implements ObjectMapper<User> {

    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User resultUser = User.newBuilder()
                .setId(rs.getLong("id"))
                .setLogin(rs.getString("login"))
                .setPassword(rs.getString("password"))
                .setEmail(rs.getString("email"))
                .setRole(Role.valueOf(rs.getString("role"))).build();

        return resultUser;
    }
}
