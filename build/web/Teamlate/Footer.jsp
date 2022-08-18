<%@page pageEncoding="UTF-8" %>
                </div>
            </div>
            <!-- footer -->
            <footer class="text-light bg-dark" style="margin-top: 20px">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3 col-lg-4 col-xl-3" style="margin-top: 20px">
                            <h5>About</h5>
                            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                            <p class="mb-0">
                                
                            </p>
                        </div>

                        <div class="col-md-2 col-lg-2 col-xl-2 mx-auto" style="margin-top: 20px">
                            <h5>Informations</h5>
                            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                            <ul class="list-unstyled">
                                <li><a href="">Link 1</a></li>
                                <li><a href="">Link 2</a></li>
                                <li><a href="">Link 3</a></li>
                                <li><a href="">Link 4</a></li>
                            </ul>
                        </div>

                        <div class="col-md-3 col-lg-2 col-xl-2 mx-auto" style="margin-top: 20px">
                            <h5>Others links</h5>
                            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                            <ul class="list-unstyled">
                                <li><a href="">Link 1</a></li>
                                <li><a href="">Link 2</a></li>
                                <li><a href="">Link 3</a></li>
                                <li><a href="">Link 4</a></li>
                            </ul>
                        </div>

                        <div class="col-md-4 col-lg-3 col-xl-3" style="margin-top: 20px">
                            <h5>Contact</h5>
                            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                            <ul class="list-unstyled">
                                <li><i class="fa fa-home mr-2"></i> My company</li>
                                <li><i class="fa fa-envelope mr-2"></i> don.darkangel@gmail.com</li>
                                <li><i class="fa fa-phone mr-2"></i> + 84966 848 850</li>
                                <li><i class="fa fa-print mr-2"></i> + 84966 848 850</li>
                            </ul>
                        </div>
                        <div class="col-12 copyright mt-3">
                            <p class="float-left">
                                <a href="#">Back to top</a>
                            </p>
                            <p class="text-right text-muted">Deverloper Website <i class="fa fa-heart"></i> by <a href="https://www.facebook.com/dondark89/"><i>Ngô Mạnh Cường</i></a> | <span>Phone: 0966.848.850</span></p>
                        </div>
                    </div>
                </div>
            </footer>            
            <!-- footer -->

<!-- Messenger Plugin chat Code -->
    <div id="fb-root"></div>

    <!-- Your Plugin chat code -->
    <div id="fb-customer-chat" class="fb-customerchat">
    </div>

    <script>
      var chatbox = document.getElementById('fb-customer-chat');
      chatbox.setAttribute("page_id", "1637317476560920");
      chatbox.setAttribute("attribution", "biz_inbox");
    </script>

    <!-- Your SDK code -->
    <script>
      window.fbAsyncInit = function() {
        FB.init({
          xfbml            : true,
          version          : 'v12.0'
        });
      };

      (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
        fjs.parentNode.insertBefore(js, fjs);
      }(document, 'script', 'facebook-jssdk'));
    </script>
<!-- Messenger Plugin chat Code -->

    </body>
</html>
