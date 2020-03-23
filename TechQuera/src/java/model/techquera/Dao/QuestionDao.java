
package model.techquera.Dao;

import com.techquera.model.Question;
import com.techquera.connection.MySqlSession;
import com.techquera.model.User;
import java.io.Serializable;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionDao implements DaoOperations<Question>{
    
    @Autowired
    private MySqlSession session;

    @Autowired
    private UserDao userdao;
    
    @Override
    public boolean save(Question ob) {
        Session ss=session.getSession();
        Date date =new Date();
        ss.save(ob);
        ob.setDate(date);
        ss.update(ob);
        ss.beginTransaction().commit();
        ss.close();
        return true;
    }

    @Override
    public boolean update(Question ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getAll(List<Question> ob) {
        
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    

    }

    @Override
    public boolean getid(Question ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Question> getQuestions()
            
    {
    
      Session ss=session.getSession();
      List<Question> qusList;
     
     Query query=  ss.createQuery("select q.question from Question q ORDER BY q.date DESC");
     qusList=query.list();
     Iterator itr=qusList.iterator();
     while(itr.hasNext())
     {
         String question=(String) itr.next();
         
         
     }
     
     ss.close();
     return qusList;
    
    
    }
    public List<Date> getDates()
            
    {
    
      Session ss=session.getSession();
      List<Date> dateList;
     
     Query query=  ss.createQuery("select q.date from Question q ORDER BY q.date DESC");
     dateList=query.list();
     Iterator itr=dateList.iterator();
     while(itr.hasNext())
     {
         Date date= (Date) itr.next();
       
         
     }
     
     ss.close();
     return dateList;
    
    
    }
     

    
        public int save1(Question ob,int id) {
          
            
        Session ss=session.getSession();
        Date date =new Date();
        User user=(User) ss.get(User.class, id);
        ob.setUser(user);
        ss.save(ob);
        
        int id6=ob.getQusId();
          
        ob.setDate(date);
        ss.update(ob);
        ss.beginTransaction().commit();
        
        return id6;
    }
        
        
          public List<User> getUSername()
            
    {
    
      Session ss=session.getSession();
      List<User> userList;
     
     Query query=  ss.createQuery("select q.us from Question q ORDER BY q.date DESC");
     userList=query.list();
   
       
     ss.close();
     return userList;
    
    
    }
          
          
    public List<Question> getQuestions1()
            
    {
    
      Session ss=session.getSession();
      List<Question> qusList1;
     
     Query query=  ss.createQuery("from Question q ORDER BY q.date DESC");
     qusList1=query.list();
     Iterator itr=qusList1.iterator();
     while(itr.hasNext())
     {
         Question qus= (Question) itr.next();
         
         
     }
     
     ss.close();
     return qusList1;
    
    
    }

    public Long count()
            
            {
            
            
      Session ss=session.getSession();
      Query query = ss.createQuery("select count(*) from Question q");
      long count =(long) query.uniqueResult();
               
         return count;   
            }
    
    
    
    public List<Question> getQuestionss(int id)
    {
    Session ss=session.getSession();
    Query query=ss.createQuery("select q.question from Question q ");
     List<Question> qusList1;
     
     qusList1=query.list();
     Iterator itr=qusList1.iterator();
     while(itr.hasNext())
     {
        String qus= (String) itr.next();
         System.out.println(qus);
         
     }
     
     ss.close();
     return qusList1;
    
        
        
        
        
        
    }
    
    
    public List<String> getAllQuestion(int id)
    {
        Session ss=session.getSession();
        
        
        
        
        User user=(User)ss.get(User.class, id);
        Set<Question> question=(Set<Question>) user.getQuestions();
        List<String> o = new ArrayList<>();
     Iterator itr=question.iterator();
     while(itr.hasNext())
     {
       Question  p=  (Question) itr.next();
         String q=p.getQuestion();
         System.out.println(q);
       o.add(q);
        
     }
         return o;
    }

}