
package model.techquera.Dao;

import java.util.List;
import org.springframework.stereotype.Component;



public interface DaoOperations <T>
{
    boolean save(T ob);
    boolean update(T ob);
    boolean getAll(List<T> ob);
    boolean getid(T ob);
    
}
