
package com.techquera.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="answer")
public class Answer implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ans_id")
    private int ansId;
    
    
    @Column(name="ans",length = 5000)
    private String ans;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ans_date")
    private Date ansDate;
    
    @Column(name="is_active")
    private boolean isActive;
    
    @Column(name="upvote")
    private int right;
    
    @Column(name="downvote")
    private int wrong;

    
    
    @ManyToOne(targetEntity = Question.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="qus_id")
    private Question qu;
    
    
    
    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User us1;
    
    public Answer() {
        this.isActive=true;
        
    }


    public Answer(int ansId, int userId, String ans, int qusId, Date ansDate, boolean isActive, int right, int wrong, Question qu) {
        this.ansId = ansId;
        this.ans = ans;
        this.ansDate = ansDate;
        this.isActive = isActive;
        this.right = right;
        this.wrong = wrong;
        this.qu = qu;
    }

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Date getAnsDate() {
        return ansDate;
    }

    public void setAnsDate(Date ansDate) {
        this.ansDate = ansDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    public Question getQu() {
        return qu;
    }

    public void setQu(Question qu) {
        this.qu = qu;
    }

    public User getUs1() {
        return us1;
    }

    public void setUs1(User us1) {
        this.us1 = us1;
    }


    @Override
    public String toString() {
        return "answer{" + "ansId=" + ansId + ", ans=" + ans + ", ansDate=" + ansDate + ", isActive=" + isActive + ", right=" + right + ", wrong=" + wrong + ", qu=" + qu + '}';
    }

    
    
    
    
    
    
    
    
    
    
    
    
   
    
}
