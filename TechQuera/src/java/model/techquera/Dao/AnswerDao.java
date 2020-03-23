/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.techquera.Dao;

import com.techquera.connection.MySqlSession;
import com.techquera.model.Question;
import com.techquera.model.User;
import com.techquera.model.Answer;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class AnswerDao implements DaoOperations<Answer>{
    
    @Autowired
    private MySqlSession session;

    
    @Autowired
    private UserDao userdao;

    @Override
    public boolean save(Answer ob) {
        
        Session ss=session.getSession();
        Date date =new Date();
        
        ss.save(ob);
        ob.setAnsDate(date);
        
        ss.update(ob);
        ss.beginTransaction().commit();
        ss.close();
        return true;
    }

    @Override
    public boolean update(Answer ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getAll(List<Answer> ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getid(Answer ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     public boolean save1(Answer ob,int id,String ans,int id1) {
        Session ss=session.getSession();
        Date date =new Date();
        
        User user1=(User) ss.get(User.class, id);
        System.out.print(ob);
        
        
        Question question1=(Question)ss.get(Question.class,id1);
        ob.setUs1(user1);
        ob.setQu(question1);
        ss.save(ob);
        ob.setAns(ans);
        ob.setAnsDate(date);
        
        ss.update(ob);
        ss.beginTransaction().commit();
        ss.close();
        return true;
}
     
     
     
     public List<Integer> getQuest()
     {
      Session ss=session.getSession();
      Query query=ss.createQuery("select q.qusId from Question q ORDER BY q.date DESC");
      List<Integer>id= query.list();
         
      
         
         
     return id;
     }
     
     public String getQuestion(int id)
     {
     Session ss=session.getSession();
     Question question=(Question) ss.get(Question.class, id);
     String ques=question.getQuestion();
         System.out.println(ques);
     return ques;
     
     }
     
}