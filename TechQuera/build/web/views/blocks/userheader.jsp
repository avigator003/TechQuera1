<%
    String ctx = application.getContextPath();
%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="q" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
 <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>TechQuera</title>
<%@include file="cache.jsp" %>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="<%=ctx%>/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=ctx%>/resources/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="<%=ctx%>/resources/css/templatemo-style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="<%=ctx%>/resources/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    </head>
    <body>
        
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
        <nav class="nav">
          <div class="burger">
            <div class="burger__patty"></div>
          </div>

          <ul class="nav__list">
            
              <li class="nav__item">
              <a href="/pro/usercontrol/interface" class="nav__link c-blue">Home</a>
            </li>
            
            <li class="nav__item">
              <a href="/pro/usercontrol/userqus" class="nav__link c-blue">Ask Question</a>
            </li>
            
            <li class="nav__item">
              <a href="<%=ctx%>/usercontrol/allQuestion" class="nav__link c-yellow scrolly"> My Questions</a>
            </li>
            
            <li class="nav__item">
              <a href="<%=ctx%>/usercontrol/editProfile" class="nav__link c-red">Edit Profile</a>
            </li>
          
                        <li class="nav__item">
              <a href="<%=ctx%>/usercontrol/logout" class="nav__link c-red">Logout</a>
            </li>1

          </ul>
        </nav>

