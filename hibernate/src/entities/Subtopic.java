package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Admin on 03.01.2015.
 */
@Entity
public class Subtopic {
    private int subId;
    private String subtopicName;

    @Id
    @Column(name = "SUB_ID")
    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "SUBTOPIC_NAME")
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
}
