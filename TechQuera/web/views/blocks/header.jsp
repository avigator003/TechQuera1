<%
    String ctx = application.getContextPath();
%>
<!doctype html>
 <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>TechQuera</title>

        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">

        <link rel="stylesheet" href="<%=ctx%>/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%=ctx%>/resources/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="<%=ctx%>/resources/css/templatemo-style.css">

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
              <a href="#1" class="nav__link c-blue"><img src="<%=ctx%>/resources/img/home-icon.png" alt=""></a>
            </li> 
            <li class="nav__item">
              <a href="<%=ctx%>/web/login1" class="nav__link c-blue"><img src="<%=ctx%>/resources/img/about-icon.png" alt=""></a>
            </li>
            
            <li class="nav__item">
              <a href="<%=ctx%>/web/register" class="nav__link c-yellow scrolly"><img src="<%=ctx%>/resources/img/about-icon.png" alt=""></a>
            </li>
            <li class="nav__item">
              <a href="#3" class="nav__link c-red"><img src="<%=ctx%>/resources/img/projects-icon.png" alt=""></a>
            </li>
            <li class="nav__item">
              <a href="#4" class="nav__link c-green"><img src="<%=ctx%>/resources/img/contact-icon.png" alt=""></a>
            </li>
          </ul>
        </nav>

