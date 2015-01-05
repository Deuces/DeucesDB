package dao;

import entities.Subtopic;
import org.hibernate.Session;
import service.HibernateService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


class SubtopicDAOImp implements SubTopicDAO {

    @Override
    public void addSubtopic(Subtopic subtopic) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.save(subtopic);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateSubtopic(Subtopic subtopic) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.update(subtopic);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Subtopic getSubtopicById(Integer id) throws SQLException {
        Session session = null;
        Subtopic subtopic =  null;
        try {
            session = HibernateService.getSession();
            subtopic = (Subtopic) session.get(Subtopic.class, id);
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return subtopic;
    }

    @Override
    public List<Subtopic> getAllSubtopics() throws SQLException {
        Session session = null;
        List<Subtopic> subtopics =  new ArrayList<Subtopic>();
        try {
            session = HibernateService.getSession();
            subtopics = session.createCriteria(Subtopic.class).list();
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return subtopics;
    }

    @Override
    public void deleteSubtopic(Subtopic subtopic) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.delete(subtopic);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
