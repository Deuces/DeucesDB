package dao;

import entities.Users;
import org.hibernate.Session;
import service.HibernateService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vadym on 19.12.2014.
 */
class UserDAOImp implements UserDAO {

    @Override
      public void addUser(Users user) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
    @Override
    public void updateUser(Users user) throws SQLException {

    }

    @Override
    public Users getUserByID(Integer id) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            Users user = (Users) session.get(Users.class, id);
            return user;
        } finally {
            if(session != null && session.isOpen())
                session.close();
        }
    }

    @Override
    public List<Users> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public void deleteUser(Users user) throws SQLException {

    }
}
