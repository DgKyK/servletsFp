package ua.alex.project.model.dao.impl;

import ua.alex.project.constants.Attributes;
import ua.alex.project.model.dao.UserDao;
import ua.alex.project.model.dao.mapper.UserMapper;
import ua.alex.project.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDao {
    private Connection connection;


    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(Attributes.DB_SQL_ALL_USERS);
            UserMapper userMapper = new UserMapper();
            while(rs.next()) {
                User user = userMapper.extractFromResultSet(rs);
                allUsers.add(user);
            }
        } catch (SQLException e) {
            //TODO create logging for this case
            e.printStackTrace();
        }
        return null;
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

    @Override
    public Optional<User> findByLogin(String login) {
        Optional<User> user = Optional.empty();
        try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE users.login = ?")) {
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
        try (PreparedStatement ps = connection.prepareStatement(Attributes.DB_SQL_SAVE)) {
            ps.setLong(1,user.getId());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4,user.getEmail());
            ps.setString(5, user.getRole().toString());
            ps.execute();
        } catch (SQLException e) {
            //TODO logging for this case
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findById(long id) {
        try(PreparedStatement ps = connection.prepareStatement(Attributes.DB_SQL_FIND_BY_ID)) {
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
}
