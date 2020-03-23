
    
<script type="text/javascript">
                function test(id)
                {
              
              
        var id1=id;
         $.ajax({

            url:"/pro/usercontrol/answ1",
              type: "GET",
        data: {"id2":JSON.stringify(id1)},
        dataType: "json",
              
            
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },

        });


        
        
        
        
        
        
        
   }
             
             
                
                    </script>

<section class="panel b-green" id="4">
          <article class="panel__wrapper">
            <div class="panel__content">
              <div class="container">
                <div class="row">
                  
                  <div class="col-md-12">
                    <div class="footer" >
                        
                                <q:set var="nFilters" value="0" />
                          
                                <q:forEach  items="${users}" var="user5">
                          

                        <q:forEach items="${qus[nFilters]}" var="quss"  >
                            
                          
                                           
                                          <q:set var="c" value="${count}"/>

            
                                              <q:set var="nFilters" value="${nFilters+1}"/>

                                  
                            
                            
                          <div style="background-color: white ;">
    
    
                                 
    
                              
                              
                              <h3 style="color: red"><h2 style="color: red;position: relative"><i class="fa fa-question-circle" style="position: relative;font-size: 45px"></i>   Question..</h2> <q:out value="${quss}"/></h3>
                             
                              
                              
                              <h3 style="color: green;font-size: 15px;position: relative;" ><span style="color: black;font-weight: bold"> Asked Date : </span><fmt:formatDate type = "date" value = "${date}" /></h3>
                             
                         <p style="color:Blue;text-transform: uppercase"><span style="color:black;font-weight: bold">Question Asked By:  </span><q:out value="${user5.getUsername()}"/></p>
                                             
                  


                 

                         <form action="/pro/usercontrol/answ1/${c-nFilters+1}" method="GET">
   
                              <div class="primary-button">
                                  <button class="btn-danger"  >Give Answer</button>
                               </div>
                            

                         </form>



            
                          </div>
            
                                                   
</q:forEach>
                       
             
                        </q:forEach>

 
                          
            


                    </div>
                  </div>
                </div>
              </div>
            </div>
          </article>
        </section>
      

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="<%=ctx%>/resources/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

        <script src="<%=ctx%>/resources/js/vendor/bootstrap.min.js"></script>

        <script src="<%=ctx%>/resources/js/plugins.js"></script>
        <script src="<%=ctx%>/resources/js/main.js"></script>

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
            e.src='//www.google-analytics.com/analytics.js';
            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
            ga('create','UA-XXXXX-X','auto');ga('send','pageview');
        </script>
    </body>
</html>