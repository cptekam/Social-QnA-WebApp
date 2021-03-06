package org.upgrad.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Answer implements Serializable {

    @Id
    private int id;
    private String ans;
    private Date date;
    private int question_id;
    @Column(name = "modifiedon")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date modifiedOn;
    private User user;

    public Answer() {
    }

    public Answer(int id, String ans, Date date, int question_id, Date modifiedOn) {
        this.id = id;
        this.ans = ans;
        this.date = date;
        this.question_id = question_id;
        this.modifiedOn = modifiedOn;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
