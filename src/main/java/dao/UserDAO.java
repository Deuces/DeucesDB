package dao;


import entities.Users;

import java.sql.SQLException;
import java.util.List;

/**
 * dao interface for user entity in oracle DB.
 * Created by Vadym on 19.12.2014.
 */
public interface UserDAO {
    void addUser(Users user) throws SQLException;
    void updateUser(Users user) throws  SQLException;
    Users getUserByID(Integer id) throws SQLException;
    List<Users> getAllUsers() throws SQLException;
    void deleteUser(Users user) throws SQLException;
}
