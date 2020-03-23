package com.techquera.controller;

import com.service.EmailService;
import com.service.PicUploadService;
import com.techquera.model.Question;
import com.techquera.model.User;
import java.io.IOException;
import java.util.Random;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.techquera.Dao.QuestionDao;
import model.techquera.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/web/")
public class WebController {

    @Autowired
    private UserDao userdao;
    
    @Autowired
    private QuestionDao quesdao;
    
    @Autowired
    private EmailService email;
    
    
    @Autowired
    private PicUploadService uploadService;

    @RequestMapping(value = "home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "register")

    public String register() {
        return "Register";
    }

    @RequestMapping(value = "save")
    public String save(User user,Question qus) throws MessagingException {
        
        int otp=otp();
        email.sendOtp(user.getEmail(), user.getUsername(), otp);
        user.setOtp(otp);
        boolean status = userdao.save(user);
        
        if (status) {
        return "redirect:/web/verify";
        } else {

            return "redirect:/web/home";
        }

    }
    
    @RequestMapping(value = "verify")
    public String verify() {

        return "verify";
    }

    @RequestMapping(value = "loginuser")
    public String loginuser(@RequestParam("email") String email, @RequestParam("Password") String Password,HttpServletRequest req) throws IOException {
        HttpSession session=req.getSession();
        
        User user = userdao.login(email, Password);
        
        
    
       
        
        session.setAttribute("user", user);
        
        if (user == null) 
            return "redirect:/web/login?err=1";
        else {
            
            if (user.isIsverify()) {
                int id=user.getUserid();
             
              
                    session.setAttribute("userid", id);
                    
                   
                String  pic =uploadService.getProfilePic(user.getUserid(),user.getProfilePic());
                user.setProfilePicString(pic);
                session.setAttribute("user", user);
                 
                return "redirect:/usercontrol/interface";
            } 
            else{
                return "redirect:/web/verify";
            }
        }
    }

    @RequestMapping(value = "login1")

    public String login1() {
        return "login";
    }

    @RequestMapping(value = "login")
    public String login(@RequestParam(value = "err", required = false, defaultValue = "0") int status1, ModelMap map) {
        String msg1 = "";
        if (status1 == 1) {
            msg1 = "Invalid User or Password !! Please Try Again";
            map.put("msg1", msg1);
          
        }
        return "login";
    }
    
    
    @RequestMapping(value="verifyus")
    public String verifyus(@RequestParam(value="email") String email,@RequestParam(value="Otp") int otp)
    {
    boolean status=userdao.check(email,otp);
    if(status==false)
    {
    return "redirect:/web/verify1?err1=1";
    }else
    {
    return "redirect:/web/login";
    }
     }
    
    @RequestMapping(value="verify1")
    public String verify1(@RequestParam(value="err1",required = false,defaultValue = "0")int status,ModelMap map)
    {
        String msg="";
    if(status==1)
    {
    msg="Invalid Otp or Email";
    map.put("msg", msg);
    }
    return "verify";
    }
  
    public int otp()
    {
    Random rn=new Random();
    return rn.nextInt(999999);
    }
    
}
