
package com.techquera.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="techquera")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name="user_id")
    private int userid;
    
    @Column(name="user_name")
    private String username;
    
    @Column(name="password")
    private String password;
    
    @Column(name="email")
    private String email;
    
    @Column(name="otp")
    private Integer otp;
    
    @Column(name="isVerify")
    private Boolean isverify;
 
    @Column(name="isActive")
    private Boolean isactive;    

    
    @Column
    private String profilePic;
    
    @Transient
    private String profilePicString;
    
    
    @OneToMany(targetEntity = Question.class,mappedBy = "us",fetch = FetchType.LAZY,cascade = CascadeType.ALL)    
    private Set<Question> questions;

    
    @OneToMany(targetEntity = Answer.class,mappedBy = "us1",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Answer> answers;
    
    public User() {
        
        this.isverify=false;
        this.isactive=true;
    }

    public User(int userid, String username, String password, String email, Integer otp, Boolean isverify, Boolean isactive, String profilePic, String profilePicString, Set<Question> questions, List<Answer> answers) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.otp = otp;
        this.isverify = isverify;
        this.isactive = isactive;
        this.profilePic = profilePic;
        this.profilePicString = profilePicString;
        this.questions = questions;
        this.answers = answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

   

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public void setProfilePicString(String profilePicString) {
        this.profilePicString = profilePicString;
    }

    public String getProfilePicString() {
        return profilePicString;
    }

   

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public Boolean isIsverify() {
        return isverify;
    }

    public void setIsverify(Boolean isverify) {
        this.isverify = isverify;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void isIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email + ", otp=" + otp + ", isverify=" + isverify + ", isactive=" + isactive + ", profilePic=" + profilePic + ", profilePicString=" + profilePicString + ", questions=" + questions + ", answers=" + answers + '}';
    }

    
}