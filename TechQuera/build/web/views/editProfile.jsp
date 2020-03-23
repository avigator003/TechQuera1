<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Profile</title>
        
        
        <link href="/pro/resources/css/editProfile.css" rel="stylesheet">
    </head>
    <body>
        <form action="/pro/usercontrol/upload" method="POST" enctype="multipart/form-data">
            <table>
                <td>
                    
                    <div class="avatar-zone" style="position:absolute;top:30px;left:600px;">
                               </div>   
  
                       <input type="file" class="upload_btn" name="pic">
                       <div class="overlay-layer" >Upload Pic</div>
                </td>
                <tr>
                    <td>
                        <input type="submit" value="Set Profile Photo" style="border-radius:15px;background-color: skyblue;height: 30px;width: 150px;    position: relative;
    top:133px;
    left:567px;">
                        
                    </td>
                </tr>
                <tr>
                    
                </tr>
            </table>
            
        </form>
        
        
    </body>
</html>
