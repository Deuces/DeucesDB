package entities;

import javax.persistence.*;

/**
 * Created by Vadym on 21.12.2014.
 */
@Entity
public class Topic {
    private int topicId;
    private String topicName;
    private Users usersByAuthorId;

    @Id
    @Column(name = "TOPIC_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Basic
    @Column(name = "TOPIC_NAME", nullable = false, insertable = true, updatable = true, length = 50)
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        if (topicId != topic.topicId) return false;
        if (topicName != null ? !topicName.equals(topic.topicName) : topic.topicName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = topicId;
        result = 31 * result + (topicName != null ? topicName.hashCode() : 0);
        return result;
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
