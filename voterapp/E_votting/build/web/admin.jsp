<%-- 
    Document   : admin
    Created on : Mar 12, 2017, 12:47:36 PM
    Author     : cijo
--%>
<%-- 
    Document   : index
    Created on : Feb 27, 2017, 10:23:30 PM
    Author     : admin
--%>
<!DOCTYPE html>
<html lang="en">
  <head>
      <%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Expires", "0");
    response.setDateHeader("Expired", -1);
    if(session.getAttribute("userid")==null)
    {
    response.sendRedirect("index.jsp");
    }
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
   

    <title>All Template Needs</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/component.css">
    <link rel="stylesheet" href="css/custom-styles.css">
    <link rel="stylesheet" href="css/font-awesome.css">
	
     
	 <link rel="stylesheet" href="css/demo.css">
    <link rel="stylesheet" href="css/font-awesome-ie7.css">
<script src="js/jquery-1.9.1.js"></script>
      <!--<script src="js/jquery.mobilemenu.js"></script>-->
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <script>
    $(document).ready(function(){
        //$('.menu').mobileMenu();
        $("#view_results").click(function(){
            //alert("");
            $("#here").load("region_list.jsp");
        });
        
        $("#view_comp").click(function(){
            //alert("");
            $("#here").load("view_compl.jsp");
        });
    });
  </script>
 
  </head>

  <body>
    <div class="header-wrapper">
      <div class="site-name">
        <h1>mMADHAAN</h1>
        <h2> </h2>
      </div>
    </div>
    <div class="menu">
      <div class="navbar">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <i class="fw-icon-th-list"></i>
            </button>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="admin.jsp">Home</a></li>
              <li id="view_results"><a href="#">View Result</a></li>
              <li id="view_comp"><a href="#">View Complaints</a></li>
              <li><a href="logout.jsp">Logout</a></li>
            </ul>
          </div><!--/.navbar-collapse -->
        </div>
      </div>
      <div class="mini-menu">
            <label>
          <select class="selectnav">
            <option value="#" selected="">Home</option>
            <option value="#">About</option>
            <option value="#">? Another action</option>
            <option value="#">? Something else here</option>
            <option value="#">? Another action</option>
            <option value="#">? Something else here</option>
            <option value="#">Services</option>
            <option value="#">Work</option>
            <option value="#">Contact</option>
          </select>
          </label>
          </div>
    </div>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="banner">
      <div id="carousel-example-generic" class="carousel slide">
  
  <!-- Wrapper for slides -->
        <div class="carousel-inner">
          <div class="item active">
            <img src="img/best-indian-flag-wide-pics.jpg" alt="">
            <div class="carousel-caption">
              <h1>mMATHDAAN</h1>
              <h2> vote safe vote easy</h2>
              <a href="#" class="btn">JAIHIND</a>
            </div>
          </div>
          <div class="item">
            <img src="img/best-indian-flag-wide-pics.jpg" alt="">
            <div class="carousel-caption">
              <h1> 2</h1>
              <h2> 5</h2>
              <a href="#" class="btn">M-MATHDAAN</a>
            </div>
          </div>
          <div class="item">
            <img src="img/best-indian-flag-wide-pics.jpg" alt="">
            <div class="carousel-caption">
              <h1> 6</h1>
              <h2> 3</h2>
              <a href="#" class="btn">M-MATHDAAN</a>
            </div>
          </div>
        </div>

  <!-- Controls -->
      <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
        <i class="fw-icon-chevron-left"></i>
      </a>
      <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
        <i class="fw-icon-chevron-right"></i>
      </a>
    </div>
    </div>
    <div class="container">
        <div class="featured-block" id="here">
      
        <!-- Example row of columns -->
<!--        <div class="row">
          <div class="col-md-3">
            <div class="block">
            <div class="thumbnail">
              <img src="img/img1.jpg" alt="" class="img-responsive">
              <div class="caption">
                <h1>Lorem ipsum</h1>
                <p>Cuibstui ipsum dolor sit amet, consectetuer adipiscing eli onec odio cuisque volutpat mattis</p>
                <a class="btn" href="#">more</a>
              </div>
              </div>
            </div>
            </div>
            <div class="col-md-3">
              <div class="block">
                <div class="thumbnail">
                    <img src="img/img2.jpg" alt="" class="img-responsive">
                    <div class="caption">
                      <h1>Fusce lacinia arcu</h1>
                      <p>Pellentesque fermentum dolor. Aliquam quam lectus, facilisis ctor, ultrices ut, element</p>
                      <a class="btn" href="#">more</a>
                    </div>
                </div>
              </div>
            </div>
            <div class="col-md-3">
              <div class="block">
                <div class="thumbnail">
                  <img src="img/img3.jpg" alt="" class="img-responsive">
                  <div class="caption">
                    <h1>Morbiin semquis</h1>
                    <p>Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean</p>
                    <a class="btn" href="#">more</a>
                  </div>
                  </div>
              </div>
            </div>
            <div class="col-md-3">
            <div class="block">
            <div class="thumbnail">
              <img src="img/img4.jpg" alt="" class="img-responsive">
              <div class="caption">
                <h1>Aliquam lectus</h1>
                <p>Morbi in sem quis dui placerat ornare. Pellentesque odio nisi, mod in, pharetra ultrici</p>
                <a class="btn" href="#">more</a>
              </div>
              </div>
            </div>
            </div>
            
          </div>-->
          
        </div> 
        <!--<div class="ruler"></div>-->  
        </div>
<!--        <div class="container">
          <div class="featured-item">
            <div class="col-md-6">
            <div class="block">
              <div class="block-title">
                <h1>Cras ornare tristi</h1>
                <h2>Vivamus vestibulum nulla nec ante  pellentesque</h2>
              </div>
              <ul>
                <li class="col-md-6"> 
                  <div class="user-info">
                    <i class="fw-icon-user icon"></i>
                    <h1>Tim nulla nec </h1>    
                    <p>Cuibstui ipsum dolor sit amet, consectetu</p>
                 </div>
               </li>
                <li class="col-md-6">
                  <div class="user-info">
                    <i class="fw-icon-pencil icon"></i>
                    <h1>Vivamus mol</h1>    
                    <p>Phasellus ultrices nulla quis nibh lorem</p>
                 </div>
                </li>
                <li class="col-md-6">
                  <div class="user-info">
                    <i class="fw-icon-tag icon"></i>
                    <h1>Phas ellus</h1>    
                    <p>Aliquam erat volutpat. Nam dui mi, tinci</p>
                 </div>
                </li>
                <li class="col-md-6">
                  <div class="user-info">
                    <i class="fw-icon-wrench icon"></i>
                    <h1>Fusce lobortis</h1>    
                    <p>Class aptent taciti sociosqu ad litora</p>
                 </div>
                </li>
                <li class="col-md-6">
                  <div class="user-info">
                    <i class="fw-icon-umbrella icon"></i>
                    <h1>Sed adipiscing</h1>    
                    <p class="last space">Praesent dapibus, neque id cursus</p>
                 </div>
                </li>
                <li class="col-md-6">
                  <div class="user-info">
                    <i class="fw-icon-coffee icon"></i>
                    <h1>Nam convallis</h1>    
                    <p class="last">Lorem ipsum dolor sit amet, consectetuer </p>
                 </div>
                </li>
              </ul>
            </div>
            </div>
            <div class="col-md-6">
              <div class="block">
                <div class="block-title">
                    <h1>Aliquam tincidunt</h1>
                    <h2>Integer vitae libero ac risus egestas placerat</h2>
                </div>
                  <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                      <div class="panel-heading accordion-caret">
                        <h4 class="panel-title">
                          <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                            Donec quis dui at dolor tempor
                          </a>
                        </h4>
                      </div>
                      <div id="collapseOne" class="panel-collapse collapse in">
                        <div class="panel-body">Morbi in sem quis dui placerat ornare. Pellentesque odio nisi, euismod in, pharetra 
                                      ultricies in, diam. Sed arcu. Cras consequat.</div>
                      </div>
                    </div>

                    <div class="panel panel-default">
                      <div class="panel-heading accordion-caret">
                        <h4 class="panel-title">
                          <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                            Vivamus molestie gravida turpis
                          </a>
                        </h4>
                      </div>
                      <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">Morbi in sem quis dui placerat ornare. Pellentesque odio nisi, euismod in, pharetra 
                                      ultricies in, diam. Sed arcu. Cras consequat.</div>
                      </div>
                    </div>

                    <div class="panel panel-default">
                      <div class="panel-heading accordion-caret">
                        <h4 class="panel-title">
                          <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                            Fusce lobortis lorem at ipsum semper 
                          </a>
                        </h4>
                      </div>
                      <div id="collapseThree" class="panel-collapse collapse">
                        <div class="panel-body">Morbi in sem quis dui placerat ornare. Pellentesque odio nisi, euismod in, pharetra 
                                      ultricies in, diam. Sed arcu. Cras consequat.</div>
                      </div>
                    </div>

                    <div class="panel panel-default">
                      <div class="panel-heading accordion-caret">
                        <h4 class="panel-title">
                          <a class="accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
                            Nam convallis pellentesque nisl
                          </a>
                        </h4>
                      </div>
                      <div id="collapseFour" class="panel-collapse collapse">
                        <div class="panel-body">Morbi in sem quis dui placerat ornare. Pellentesque odio nisi, euismod in, pharetra 
                                      ultricies in, diam. Sed arcu. Cras consequat.</div>
                      </div>
                    </div>
                </div>
              </div>
            </div>
          </div>-->
          <div class="ruler"></div>
        </div>
      <div class="container">
        <div class="featured-content">
          <div class="col-md-6">
            <div class="block">
              <img src="img/salute.jpg" alt="" class="img-spacing thumbnail">
              <h1> 7 </h1>
              <p>8 
              </p>
              <p>vande matharam
              </p>
              <1--<a href="#" class="btn">more</a>-->
            </div>            
          </div>
          <div class="col-md-6">
            <div class="block">
              <img src="img/download.jpeg" alt="" class="img-spacing thumbnail">
             <!-- <h1>Sed adipiscing ornare risus Morbi est est</h1>-->
              <p>India is the largest democratic country in the world. Democracy is defined as a government of the people, by the people and for the people.</p>
              <p>Democracy is considered the finest form of government in which every individual participates consciously and in which the people remain the sovereign power determining their destiny. So, in democracy the people are the ultimate source of power and its success and failure depend on their wisdom, consciousness and vigilance</p>
             <!-- <a href="#" class="btn">more</a>-->
            </div>            
          </div>
        </div>
      </div> 
<!--      <div class="footer-wrapper">
        <div class="site-content">
      <div class="container">
        <div class="row">
        
          <div class="block col-md-2 col-sm-6">
            <h1>Vitae lin</h1>
            <ul>
              <li><a href="#">Phasellus ultrices</a></li>
              <li><a href="#">Sed adipiscing lipsum</a></li>
              <li><a href="#">Nulla sed leoniton</a></li>
            </ul>
          </div>
          <div class="block col-md-2 col-sm-6">
            <h1>Luctrus</h1>
            <ul>
              <li><a href="#">Lorem ipsum</a></li>
              <li><a href="#">Donec nec justo</a></li>
              <li><a href="#">Morbi in se</a></li>
            </ul>
          </div>
          <div class="block col-md-2 col-sm-6">
            <h1>consetu</h1>
            <ul>
              <li><a href="#">Quisque a lectus</a></li>
              <li><a href="#">Donec consecte</a></li>
              <li><a href="#">Nulla sed leoniton</a></li>
            </ul>
          </div>
          <div class="block col-md-3">
            <h1>Praesent dapibus, neque id cursus faucibus</h1>
            <div class="input-group">
                <input type="email" value="" name="EMAIL" class="required email form-control" id="mce-EMAIL">
                <span class="input-group-btn">
              <input type="submit" class="button btn btn-default" value="Subscribe" name="subscribe" id="mc-embedded-subscribe">
                </span>
            </div> 
          </div>
          <div class="block col-md-3">
            <h1> Aliquam quam lectusfacilisis auctor</h1>
            <ul class="social">
              <li><a href="#"><i class="fw-icon-twitter"></i></a></li>
              <li><a href="#"><i class="fw-icon-facebook"></i></a></li>
              <li><a href="#"><i class="fw-icon-linkedin"></i></a></li>
            </ul>
          </div>
        </div>
        </div>
        
      </div>-->
      <div class="copy-rights">
      <div class="container">
        <div class="row">
          
            <!--<div class="col-md-6">
              Copyright(c) website name. Designed by: <a href="http://www.alltemplateneeds.com"> www.alltemplateneeds.com</a>
            </div>
            <div class="col-md-6">
              Images from: <a href="http://www.wallpaperswide.com">http://wallpaperswide.com</a> / <a href="http://www.wallcoo.net"> www.wallcoo.net</a>
            </div>-->
            
          </div>
        </div>
      </div>
      </div>

      


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="js/bootstrap.js"></script>
    <script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    
    
  </body>
</html>


