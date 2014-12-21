package dao;


/**
 * Created by Vadym on 20.12.2014.
 */
public class FactoryDAO {
    private static FactoryDAO instance = null;
    private static UserDAO userDAO = null;
    private static TopicDAO topicDAO = null;
    private static SubTopicDAO subtopicDAO = null;
    private static PostDAO postDAO = null;

    public static synchronized FactoryDAO getInstance() {
        if(instance == null){
            instance = new FactoryDAO();
        }
        return instance;
    }

    public UserDAO getUserDAO(){
        if(userDAO == null){
            userDAO = new UserDAOImp();
        }
        return userDAO;
    }
    public TopicDAO getTopicDAO(){
        if(topicDAO == null){
            topicDAO = new TopicDAOImp();
        }
        return topicDAO;
    }
    public SubTopicDAO getSubtopicDAO(){
        if(subtopicDAO == null){
            subtopicDAO = new SubtopicDAOImp();
        }
        return subtopicDAO;
    }
    public PostDAO getPostDAO(){
        if(postDAO == null){
            postDAO = new PostDAOImp();
        }
        return postDAO;
    }
}
