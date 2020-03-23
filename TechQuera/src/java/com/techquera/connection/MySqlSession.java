
package com.techquera.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MySqlSession {
    
    private SessionFactory sf;
    public Session getSession()
    {
        Configuration cfg=new Configuration().configure();
        if(sf==null)
        sf=cfg.buildSessionFactory();
        
        
        return sf.openSession();
       
    }
}
  

