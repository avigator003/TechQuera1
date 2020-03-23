package com.techquera.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="question")
public class Question implements Serializable {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    @Column(name="qus_id")
    private int qusId;
    
    @Column(name="question",length = 1000)
    private String question;
   
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @Column
    private boolean isActive;

   @ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id")
   private User us;
   
   
   @OneToMany(targetEntity = Answer.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "qu")
   
   private List<Answer> answers;
   
    public Question() {
        
        this.isActive=true;
    }

    public Question(int qusId, String question, boolean isActive, User us, List<Answer> answers) {
        this.qusId = qusId;
        this.question = question;
        this.isActive = isActive;
        this.us = us;
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


    
    

    public int getQusId() {
        return qusId;
    }

    public void setQusId(int qusId) {
        this.qusId = qusId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUs() {
        return us;
    }

    public void setUs(User us) {
        this.us = us;
    }



    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public User getUser() {
        return us;
    }

    public void setUser(User user) {
        this.us= user;
    }

    @Override
    public String toString() {
        return "Question{" + "qusId=" + qusId + ", question=" + question + ", date=" + date + ", isActive=" + isActive + ", us=" + us + ", answers=" + answers + '}';
    }

    


}