package dao;

import entities.Topic;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vadym on 19.12.2014.
 */
public interface TopicDAO {
    void addTopic(Topic topic) throws SQLException;
    void updateTopic(Topic topic) throws  SQLException;
    Topic getTopicById(Integer id) throws SQLException;
    List<Topic> getAllTopics() throws SQLException;
    void deleteTopic(Topic topic) throws SQLException;
}
