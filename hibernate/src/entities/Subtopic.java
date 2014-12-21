package entities;

import javax.persistence.*;

/**
 * Created by Vadym on 21.12.2014.
 */
@Entity
public class Subtopic {
    private int subId;
    private String subtopicName;
    private Topic topicByParentId;
    private Users usersByAuthorId;

    @Id
    @Column(name = "SUB_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "SUBTOPIC_NAME", nullable = false, insertable = true, updatable = true, length = 50)
    public String getSubtopicName() {
        return subtopicName;
    }

    public void setSubtopicName(String subtopicName) {
        this.subtopicName = subtopicName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subtopic subtopic = (Subtopic) o;

        if (subId != subtopic.subId) return false;
        if (subtopicName != null ? !subtopicName.equals(subtopic.subtopicName) : subtopic.subtopicName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subId;
        result = 31 * result + (subtopicName != null ? subtopicName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "TOPIC_ID", nullable = false)
    public Topic getTopicByParentId() {
        return topicByParentId;
    }

    public void setTopicByParentId(Topic topicByParentId) {
        this.topicByParentId = topicByParentId;
    }

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "USER_ID", nullable = false)
    public Users getUsersByAuthorId() {
        return usersByAuthorId;
    }

    public void setUsersByAuthorId(Users usersByAuthorId) {
        this.usersByAuthorId = usersByAuthorId;
    }
}
