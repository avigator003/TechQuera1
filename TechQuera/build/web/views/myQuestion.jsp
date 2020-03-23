<%-- 
    Document   : myQuestion
    Created on : 3 Mar, 2020, 8:57:45 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="q"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <q:forEach  items="${qusList}" var="date" >
            <p> ${date}</p>
        
        </q:forEach>
        
    </body>
</html>
