package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Vadym on 05.01.2015.
 */
@Entity
public class Users {
    private int userId;
    private String login;
    private String pass;

    @Id
    @Column(name = "USER_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "LOGIN", nullable = false, insertable = true, updatable = true, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "PASS", nullable = true, insertable = true, updatable = true, length = 50)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (pass != null ? !pass.equals(users.pass) : users.pass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }
    @Override
    public String toString(){
        return "id: " + userId + " login: " + login;
    }
}
