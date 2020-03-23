<%@include file="blocks/header.jsp" %>

<section class="panel b-green" id="4">
          <article class="panel__wrapper">
            <div class="panel__content">
              <div class="container">
                <div class="row">
                  <div class="col-md-8 col-md-offset-2">
                    <div class="contact-content">
                      <div class="heading">
                        <h4>Verify User</h4>
                      </div>
                      <div class="row">
                        <div class="col-md-8">
                          <div class="contat-form">
                            <form id="contact" action="<%=ctx%>/web/verifyus" method="post">
                                <fieldset>
                                <input name="email" type="email" class="form-control" id="email" placeholder="Email"  required>
                              </fieldset>
                              <fieldset>
                                <textarea name="Otp" rows="6" class="form-control" id="message" placeholder="Otp"  required></textarea>
                              </fieldset>
                                <fieldset>
                                    <b class="text-danger"> ${msg}</b>
                                </fieldset>
                              <fieldset>
                                <button type="submit" id="form-submit" class="btn">Verify User</button>
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