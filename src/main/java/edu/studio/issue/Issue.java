package edu.studio.issue;

import java.util.Date;
import java.util.Objects;

public class Issue implements Comparable<Issue> {

    private long id;
    private Date createdAt;
    private Date closedAt;
    private User user; // creator
    private int number;
    private boolean state;
    private String title;
    private String body;
    private User assignee;

    public Issue() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
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
        Issue other = (Issue) obj;
        return id == other.id;
    }



    @Override
    public String toString() {
        return "Issue [id=" + id + ", createdAt=" + createdAt + ", closedAt=" + closedAt + ", user=" + user
                + ", number=" + number + ", state=" + state + ", title=" + title + ", body=" + body + ", assignee="
                + assignee + "]";
    }

    @Override
    public int compareTo(Issue other) {
        // TODO Auto-generated method stub
        // based on id
        // comparing this and other by id
        if (this.id > other.id) {
            return 1;
        }
        else if (this.id < other.id) {
            return -1;
        }
        return 0;
    }

}
