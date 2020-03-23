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
                                       
                                        
                                        
                                        <q:if test="${pic!=null}" >
                                            <img src="data:image/jpg;base64,${pic}" height="100px" width="100px" style="border-radius: 50px;position: absolute;top:50px;left:0px;">

                                        </q:if>

                                        <q:if test="${pic==null}">
                                            <img src="<%=ctx%>/resources/img/right-home-image.png" height="120">
                                        </q:if>
                                        <h3 class="text-danger"><em>Hi</em> ${uname} !</h3>                                  
                                    </div>
                                    <div class="col-lg-7 col-md-7 col-sm-7">
                                        <h2 class="text-info">Ask New Question</h2>
                                        <form action="<%=ctx%>/usercontrol/qus">
                                            <textarea class='form-control' name="question" required></textarea>
                                            <br>
                                            <button type='submit' class="btn btn-success">Send Qus</button>
                                        </form>
                                    </div>
                                </div> 
                                <hr>
                                
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12">
                                        <div class="qus-content">
                                          <div class="about-box-text">
                                            <h4>Gopal Verma , 31/12/2019</h4>
                                            <p>Nulla vel accumsan dui. Aliquam tincidunt elit elit, nec iaculis neque interdum dictum. Donec venenatis quam enim, eu mattis arcu rhoncus id. Ut ac urna tellus.</p>
                                            
                                           </div>
                                        </div>
                                    </div>
                                </div>
                                
                </div>     
            </div>
        </div>
    </article>
</section>        

<%@include file="blocks/footer.jsp" %>       