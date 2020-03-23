
package model.techquera.Dao;

import com.techquera.connection.MySqlSession;
import com.techquera.model.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class UserDao implements DaoOperations<User>{
    
    @Autowired
    private MySqlSession session;

    @Override
    public boolean save(User ob) {
        try{
        Session ss=session.getSession();
        ss.save(ob);
        ss.beginTransaction().commit();
        ss.close();
        return true;
       }
        catch(Exception e)
        {
            System.err.print("Save User failed"+e.getMessage());
            return false;
        }
          }

    @Override
    public boolean update(User ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getAll(List<User> ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getid(User ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public User login(String email,String Password)
    {
        User user=null;
    Session ss=session.getSession();
    Query query=(Query) ss.createQuery("from User where email=:em and password=:pwd");
            query.setString("em",email);
            query.setString("pwd",Password);
            user=(User)query.uniqueResult();
            ss.close();
            return user;
            
    
    }
    
    
    public boolean check(String email,int otp)
    {
        
            User user=null;
    Session ss=session.getSession();
    Query query=ss.createQuery("from User where email=:em and otp=:op");
            query.setString("em", email);
            query.setInteger("op", otp);
            user=(User) query.uniqueResult();
            if(user==null)
            {
            return false;
            }
            else{
                user.setIsverify(true);
                ss.update(user);
                ss.beginTransaction().commit();
                ss.close();
            return true;
            }
                    
    }
    
       public User get(int id)
    {
    Session ss=session.getSession();
    User user=(User) ss.get(User.class,id);
    ss.close();
    return user;
    
    }
       
       
        
    public boolean update2(User ob) {
        
        Session ss=session.getSession();
        ss.update(ob);
        ss.beginTransaction().commit();
        ss.close();
        return true;
        
    }
 
}
