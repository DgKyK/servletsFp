package ua.alex.project.model.dao.impl;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.dao.UserDao;
import ua.alex.project.model.dao.mapper.UserMapper;
import ua.alex.project.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class JDBCUserDao implements UserDao {
    private Connection connection;
    private ResourceBundle bundle;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
        bundle = ResourceBundle.getBundle(Attributes.DB_PROPERTIES_NAME);
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(bundle.getString(Attributes.DB_SQL_ALL_USERS));
            UserMapper userMapper = new UserMapper();
            while(rs.next()) {
                User user = userMapper.extractFromResultSet(rs);
                allUsers.add(user);
            }
        } catch (SQLException e) {
            //TODO create logging for this case
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Optional<User> user = Optional.empty();
        try(PreparedStatement ps = connection.prepareStatement(bundle.getString(Attributes.DB_SQL_FIND_USER_BY_LOGIN))) {
            ps.setString(1,login);
            ResultSet rs = ps.executeQuery();
            UserMapper userMapper = new UserMapper();
            if(rs.next()) {
               User userFromDb = userMapper.extractFromResultSet(rs);
               user = Optional.of(userFromDb);
               return user;
            }
        } catch (SQLException e) {
            //TODO logging this case
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void save(User user) {
        try (PreparedStatement ps = connection.prepareStatement(bundle.getString(Attributes.DB_SQL_SAVE_USER))) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3,user.getEmail());
            ps.setString(4, user.getRole().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            //TODO logging for this case
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findById(long id) {
        try(PreparedStatement ps = connection.prepareStatement(bundle.getString(Attributes.DB_SQL_FIND_USER_BY_ID))) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            UserMapper userMapper = new UserMapper();
            if(rs.next()) {
                return Optional.of(userMapper.extractFromResultSet(rs));
            }
        } catch (SQLException e) {
            //TODO logging for this case
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            //TODO logging for this case
            throw new RuntimeException(e);
        }
    }
}
