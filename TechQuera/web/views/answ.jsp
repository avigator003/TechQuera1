<%@include file="blocks/userheader.jsp" %>

<section class="panel b-blue" id="1">
    <article class="panel__wrapper">
        <div class="panel__content">
            <div class="container">
                <div class="row">
                    <div class="col-md-11 col-md-offset-1">
                        <div class="home-content">
                            <div class="home-heading">
                                <div class="row">
                                    <div class="col-lg-5 col-md-5 col-sm-5">
                                        
                                        
                                        
                                        
                                        
                                        <sp:if test="${pic==null}">
                                            <img src="<%=ctx%>/resources/img/right-home-image.png" height="120">
                                        </sp:if>
                                        <h3 class="text-danger"><em>Hi</em> ${uname} !</h3>                                  
                                    </div>
                                    
                                    
                                    
                                    
                                    <div class="col-lg-7 col-md-7 col-sm-7">
                                        <form action="<%=ctx%>/usercontrol/ans2">
                                            <p style="color:orange;font-size: 20px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:yellowgreen;font-size: 40px;">Q.</span>&nbsp;&nbsp; ${quesp}</p>
                                            <textarea class='form-control' name="answer" required></textarea>
                                            <br>
                                            <button type='submit' class="btn btn-success">Give Answer</button>
                                        </form>
                                    </div>
                                </div> 
                                <hr>
                                
                                
                                
                </div>     
            </div>
        </div>
    </article>
</section>        

<%@include file="blocks/footer.jsp" %>       