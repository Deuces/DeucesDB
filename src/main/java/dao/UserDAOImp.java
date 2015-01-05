package dao;

import entities.Users;
import org.hibernate.Session;
import service.HibernateService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateUser(Users user) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Users getUserByID(Integer id) throws SQLException {
        Session session = null;
        Users user =  null;
        try {
            session = HibernateService.getSession();
            user = (Users) session.get(Users.class, id);
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public List<Users> getAllUsers() throws SQLException {
        Session session = null;
        List<Users> users =  new ArrayList<Users>();
        try {
            session = HibernateService.getSession();
            users = session.createCriteria(Users.class).list();
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    @Override
    public void deleteUser(Users user) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
