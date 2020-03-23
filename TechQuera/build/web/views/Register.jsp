<%@include file="blocks/header.jsp" %>




<section class="panel b-green" id="4">
          <article class="panel__wrapper">
            <div class="panel__content">
              <div class="container">
                <div class="row">
                  <div class="col-md-8 col-md-offset-2">
                    <div class="contact-content">
                      <div class="heading">
                        <h4>Register here</h4>
                      </div>
                      <div class="row">
                        <div class="col-md-8">
                          <div class="contat-form">
                            <form id="contact" action="<%=ctx%>/web/save" method="post">
                              <fieldset>
                                <input name="username" type="text" class="form-control" id="name" placeholder="User Name" required>
                              </fieldset>
                              <fieldset>
                                <input name="email" type="email" class="form-control" id="email" placeholder="Email" required>
                              </fieldset>
                              <fieldset>
                                <input type="password" name="Password" rows="6" class="form-control" id="message" placeholder="Password" required>
                              </fieldset>
                              <fieldset>
                                <button type="submit" id="form-submit" class="btn">Sign up</button>
                              </fieldset>
                            </form>
                          </div>
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


