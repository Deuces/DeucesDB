package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Admin on 03.01.2015.
 */
@Entity
public class Post {
    private int postId;
    private String postTittle;
    private String description;
    private String pictureUrl;

    @Id
    @Column(name = "POST_ID")
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "POST_TITTLE")
    public String getPostTittle() {
        return postTittle;
    }

    public void setPostTittle(String postTittle) {
        this.postTittle = postTittle;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "PICTURE_URL")
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (postId != post.postId) return false;
        if (description != null ? !description.equals(post.description) : post.description != null) return false;
        if (pictureUrl != null ? !pictureUrl.equals(post.pictureUrl) : post.pictureUrl != null) return false;
        if (postTittle != null ? !postTittle.equals(post.postTittle) : post.postTittle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId;
        result = 31 * result + (postTittle != null ? postTittle.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pictureUrl != null ? pictureUrl.hashCode() : 0);
        return result;
    }
}
