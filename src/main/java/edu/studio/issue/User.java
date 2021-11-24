package edu.studio.issue;

import java.util.Objects;

public class User {

    private long id;
    private String login;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login + "]";
    }

    public int compareTo(User other) {
        
        if (this.id > other.id) {
            return 1;
        }
        else if (this.id < other.id) {
            return -1;
        }
        return 0;
    }

    
    
}
