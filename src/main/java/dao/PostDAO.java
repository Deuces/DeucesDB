package dao;

import entities.Post;

import java.sql.SQLException;
import java.util.List;


public interface PostDAO {
    void addPost(Post post) throws SQLException;
    void updatePost(Post post) throws SQLException;
    Post getPostById(Integer id) throws SQLException;
    List<Post> getAllPosts() throws SQLException;
    void deletePost(Post post) throws SQLException;
}