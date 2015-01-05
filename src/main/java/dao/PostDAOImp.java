package dao;

import entities.Post;
import org.hibernate.Session;
import service.HibernateService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadym on 20.12.2014.
 */
class PostDAOImp implements PostDAO {

    @Override
    public void addPost(Post post) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.save(post);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updatePost(Post post) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.update(post);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Post getPostById(Integer id) throws SQLException {
        Session session = null;
        Post post =  null;
        try {
            session = HibernateService.getSession();
            post = (Post) session.get(Post.class, id);
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return post;
    }

    @Override
    public List<Post> getAllPosts() throws SQLException {
        Session session = null;
        List<Post> posts =  new ArrayList<Post>();
        try {
            session = HibernateService.getSession();
            posts = session.createCriteria(Post.class).list();
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return posts;
    }

    @Override
    public void deletePost(Post post) throws SQLException {
        Session session = null;
        try {
            session = HibernateService.getSession();
            session.beginTransaction();
            session.delete(post);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
