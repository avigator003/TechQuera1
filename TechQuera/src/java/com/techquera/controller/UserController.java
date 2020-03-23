package com.techquera.controller;

import com.service.PicUploadService;
import com.techquera.model.Question;
import com.techquera.model.User;
import com.techquera.model.Answer;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.techquera.Dao.AnswerDao;
import model.techquera.Dao.QuestionDao;
import model.techquera.Dao.UserDao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/usercontrol")
public class UserController {
    
 
    @Autowired
    private UserDao userdao;
    
    @Autowired
    private QuestionDao qusdao;
    
    @Autowired
    private PicUploadService uploadService;
    
    @Autowired
    private AnswerDao ansdao;
    
    @RequestMapping(value="interface")
    public String UserInterface(HttpServletRequest req,ModelMap map)
    {
        HttpSession session=req.getSession();
        User user=(User) session.getAttribute("user");
   Long count=qusdao.count();
        
        
        map.put("count",count);
        
        List<Question> quss= qusdao.getQuestions();
        List<Date> date1=qusdao.getDates();
        req.setAttribute("qus", quss);
        map.put("qus",quss);
        req.setAttribute("date1",date1);
        map.put("date1",date1);
        List<User> users=qusdao.getUSername();
        map.put("users",users);
       
        
        
       Iterator itr=users.iterator();
       while(itr.hasNext())
     {
         
         User user7= (User) itr.next();
         String username=user7.getUsername();
         
        
  }
        
        
        
        
         return "UserInterface";
    }
    
    
    @RequestMapping(value="logout")
    public String logout(HttpServletRequest req)

    {
        HttpSession session=req.getSession();
        req.removeAttribute("user");
        session.invalidate();
        
        return "redirect:/web/login1";
    
    }
    
    
    @RequestMapping(value="userqus")
    public String userqs(HttpServletRequest req,ModelMap map)
    {
          HttpSession session=req.getSession();
        Object ob=session.getAttribute("user");
       if(ob==null)
       {
            return "redirect:/web/login1";
        }
        User user= (User)ob;
        map.put("pic",user.getProfilePicString());
        map.put("uname",user.getUsername());
          int id1=(int) session.getAttribute("userid");
        
        return "userqus";
       
    
    }
    
    @RequestMapping(value="qus")
    public String qus(Question ques,HttpServletRequest req){
        
          HttpSession session=req.getSession();
          
          int id1=(int) session.getAttribute("userid");
        
          int id=qusdao.save1(ques,id1);
         
    if(id!=0)
    {
       
      return "redirect:/usercontrol/userqus";
    }
    else
        return "redirect:/usercontrol/interface";
    
    
    
    }
    
    @RequestMapping(value="/answ1/{id}",method = RequestMethod.GET)
  
    public  String answer(HttpServletRequest req,Question qus,@PathVariable(value = "id") int id,ModelMap map)
    {
        
        
   HttpSession session=req.getSession();
   session.setAttribute("id8", id);
   String question=ansdao.getQuestion(id);
        System.out.println(question);
   map.put("quesp", question);
        
    return "answ";
    
    }
    
    
    
      @RequestMapping(value="upload",method=RequestMethod.POST)
   public String upload(@RequestParam("pic")MultipartFile file,ModelMap map,HttpServletRequest request ) throws IOException
   {
   HttpSession session=request.getSession();
   User user=(User) session.getAttribute("user");
   int id=user.getUserid();
   String filename=uploadService.uploadPic(file, id);
   
   if(filename==null)
   {
   return "redirect:/usercontrol/interface";
   }
   else{
       
   User user1=userdao.get(id);
   user1.setProfilePic(filename);
   userdao.update2(user1);
   System.out.println("update completed");
   String  pic =uploadService.getProfilePic(user1.getUserid(),user1.getProfilePic());
   user1.setProfilePicString(pic);
   session.setAttribute("user", user1);
   return "redirect:/usercontrol/interface";
   }
   }
   
   
   
   @RequestMapping(value="editProfile")
   public String EditProfile(ModelMap map)
   {
       
        List<Question> quss1= qusdao.getQuestions1();
        map.put("qus1",quss1);
   return "editProfile";
   }
   
   
   @RequestMapping(value="showQuestion")
   public String show(ModelMap map,HttpServletRequest req)
   {
       HttpSession ss=req.getSession();
  List<Question> quss= qusdao.getQuestions();
 
   map.put("quss",quss);
   
   return "redirect:/usercontrol/interface";
   }
   
   
   @RequestMapping(value="ans2")
   public String ans(Answer ans1,HttpServletRequest req,@RequestParam(value = "answer")String ans)
   {
   HttpSession session=req.getSession();
   int id1=(int) session.getAttribute("userid");
   int id6=(int)session.getAttribute("id8");
   boolean status=ansdao.save1(ans1, id1, ans,id6);
   
   if(status)
   {
   return "redirect:/usercontrol/interface";
   }
   return "redirect:/usercontrol/answ";
   }
   
   
   
   
   @RequestMapping(value="allQuestion")
   public String allQuestions(HttpServletRequest req,ModelMap map)
   {
       HttpSession session=req.getSession();
       int id=(int) session.getAttribute("userid");
       
     qusdao.getAllQuestion(id);
      
       
       
 return "myQuestion";
   }
   
}
