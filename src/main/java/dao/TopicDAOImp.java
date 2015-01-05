package dao;

import entities.Topic;
import org.hibernate.Session;
import service.HibernateService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class TopicDAOImp implements TopicDAO {

    @Override
    public void addTopic(Topic topic) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.save(topic);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateTopic(Topic topic) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.update(topic);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Topic getTopicById(Integer id) throws SQLException {
        Session session = null;
        Topic topic =  null;
        try {
            session = HibernateService.getSession();
            topic = (Topic) session.get(Topic.class, id);
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return topic;
    }

    @Override
    public List<Topic> getAllTopics() throws SQLException {
        Session session = null;
        List<Topic> topics =  new ArrayList<Topic>();
        try {
            session = HibernateService.getSession();
            topics = session.createCriteria(Topic.class).list();
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return topics;
    }

    @Override
    public void deleteTopic(Topic topic) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.delete(topic);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
