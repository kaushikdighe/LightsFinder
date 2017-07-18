<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lights - Successful Listings</title>
	<!-- ===========================
	    FAVICONS
	    =========================== -->
	    <link rel="icon" href="img/favicon.png">
	    <link rel="apple-touch-icon" sizes="144x144" href="img/apple-touch-icon-ipad-retina.png" />
	    <link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-iphone-retina.png" />
	    <link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-ipad.png" />
	    <link rel="apple-touch-icon" sizes="57x57" href="img/apple-touch-icon-iphone.png" />
	    
	    <!-- ===========================
	    STYLESHEETS
	    =========================== --> 
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
	    <link rel="stylesheet" href="css/style.css">
	    <link rel="stylesheet" href="css/responsive.css">
	    <link rel="stylesheet" href="css/animate.css">
	    
	    <!-- ===========================
	    FONTS
	    =========================== -->
	    <link href='http://fonts.googleapis.com/css?family=Raleway:400,900,600|Pacifico' rel='stylesheet' type='text/css'>
</head>
<body>
<%
	String message = (String) request.getAttribute("message");
%>
	<!-- ===========================
    HERO SECTION
    =========================== -->
    <div id="hero">
        <div class="redoverlay">
            <div class="container">
                <div class="row">
                    <div class="herotext">
                    
                    <ul class="main-menu">
                    	<li><a href="/ChristmasLightFinder/ChristmasLighting">Home</a></li>
                        <li><a href="/ChristmasLightFinder/ShowListing">Search Listings</a></li>
                        <li><a href="addlistings.jsp">Add Listings</a></li>
                    </ul>
                    
                    <div class="col-md-12">
                        <h1 class="wow flipInY header_txt">Lights Finder</h1>
                    </div>	                       
                    
                    <img class="bigbell wow tada infinite" data-wow-duration="30s" src="img/bell.png" alt="">
        					<p class="wow fadeInUp" data-wow-duration="2s">A</p>
                    </div>
                 </div>
             </div>
         </div>
     </div><br>
    <!--HERO SECTION END-->
     <!-- ===========================
    OVERVIEW SECTION
    =========================== --> 
    
    <!-- ===========================
    PRODUCTS SECTION
    =========================== -->
    <div id="products" class="container">

        <!--SECTIONHEAD START-->
        
    </div><!--PRODUCTS SECTION END-->
     <center><span class="highlight"><%= message %></span></center>
    <!-- ===========================
    SUBSCRIBE SECTION
    =========================== -->
    <div id="subscribe">
        <div class="darkoverlay">
            <div class="container text-center">
                <img class="santaicon wow tada infinite" data-wow-duration="20s" src="img/santa-sm.png" alt="">
                
                <!--MAILCHIMP FORM START-->  
                <div class="mailchimp">
                    
                </div>
            </div><!--SUBSCRIBE CONTAINER END-->
        </div><!--OVERLAY END-->
    </div><!--SUBSCRIBE SECTION END-->        
    
    <!-- ===========================
    FOOTER
    =========================== -->
    <!-- ===========================
    SOCIAL ICONS
    =========================== -->
    
    <!-- ===========================
    NECESSARY SCRIPTS
    =========================== --> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script src="js/evenfly.js"></script>
    <script src="js/jquery.nicescroll.min.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/snowstorm-min.js"></script>
    <script>new WOW().init();</script>    
</body>
</html>