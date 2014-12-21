package dao;


import entities.Subtopic;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vadym on 19.12.2014.
 */
public interface SubTopicDAO {
    void addSubtopic(Subtopic subtopic) throws SQLException;
    void updateSubtopic(Subtopic subtopic) throws SQLException;
    Subtopic getSubtopicById(Integer id) throws  SQLException;
    List<Subtopic> getAllSubtopics() throws SQLException;
    void deleteSubtopic(Subtopic subtopic) throws SQLException;
}
