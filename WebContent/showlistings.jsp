<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- ===========================
    THEME INFO
    =========================== -->    
    <meta name="description" content="SantaGo is another free Bootstrap HTML Christmas sales and affiliate page template built and distributed by EvenFly Team as a small Cristmas gift under Creative Commons 3.0 license.">
    <meta name="keywords" content="Christmas Template, Free Christmas Landing Page, Christmas Affiliate Landing Page, Free Christmas Sales Page Template">
    <meta name="author" content="Mamun Srizon">
    
    <!-- ===========================
    SITE TITLE
    =========================== -->
    <title>Lights Finder-Search Listings</title>
    
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
    
    <script type="text/javascript">
	    
    	function searchByCity()
	    {
	    	//alert('here');
	    	
	    	var selectvalue = document.getElementById("city").value;
	    	document.getElementById("selectvalue").value = selectvalue;
	    	
	    	//alert(document.getElementById("selectvalue").value);
	    }
    	
    	
    </script>
    
</head>

<body>
<%
	List<HashMap<String, String>> list = (List<HashMap<String,String>>)request.getAttribute("showListings");
	System.out.println("-----list in jsp is-----"+list);
	ArrayList<String> cityList = (ArrayList<String>) request.getAttribute("cityList");
	System.out.println("-----citylist in jsp is-----"+cityList);
	String hiddenValue = (String) request.getAttribute("hiddenvalue") ;
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
                                    <li><a href="#" class="active">Search Listings</a></li>
                                    <li><a href="addlistings.jsp">Add Listings</a></li>
                                </ul>
						
                        
                        <div class="col-md-12">
                        	<h1 class="wow flipInY header_txt">Lights Finder</h1>
                        </div>	                       
                        <!--<h2 class="wow zoomInDown" data-wow-duration="3s">HoHo its the Holiday Season!</h2>-->
                        

                        <!--<a class="btn btn-reverse wow zoomIn" href="#products">
                            <h3> <span class="optional">Seach for the best decorated houses around your area!</span></h3>                            
                        </a>--><!--#NOTE: texts inside the OPTIONAL tag above would be hidden on smaller mobile screens -->
                
                    <!--Search field <form class="searchfield">
                                                      
                            <input class="s-field" type="text" value="" name="FNAME" id="mce-FNAME" placeholder="Search for the best decorated houses around your area!" required>
                         
                            <input type="submit" value="Search" name="subscribe" id="mc-embedded-subscribe" class="btn btn-inverse btn-search">
                    </form>-->
                        <img class="bigbell wow tada infinite" data-wow-duration="30s" src="img/bell.png" alt="">
        
                        <p class="wow fadeInUp" data-wow-duration="2s">A</p>

                    </div>

                    
                    </div>
                </div>
            </div>
        </div><!--HERO SECTION END-->
    
    <!-- ===========================
    PRODUCTS SECTION
    =========================== -->
    
    
<!-- ===========================
PRODUCTS SECTION
=========================== -->
<div id="products" class="container">
		<div class="row">
        	<div class="col-md-4 col-md-offset-4">
            	<form name="slistings" method="get" action="ShowListing">
                    <div id="cityddr">
                        <label for="" class="center-block">CITY</label>
                        <select class="form-control" id="city" onChange="searchByCity()">
                                <option selected='selected'>Select a City</option>
                                <% for(int i = 0; i < cityList.size(); i++){%>
                                <option value="<%=cityList.get(i)%>"><%=cityList.get(i)%></option>	
                                <%}%>
                        </select>
                        <input type="hidden" name="selectvalue" id="selectvalue"/>
                        <input type="submit" class="btn btn-default center-block" value="Search"/>
                    </div>
                </form>
            </div>        
        </div>


        <!--SECTIONHEAD START-->
        <div class="sectionhead text-center">
            <h2>Search Listings</h2>
            <hr>
        </div><!--SECTIONHEAD END-->

        <hr><!--SEPARETOR LINE-->

        <!--SMALL ITEM 1ST ROW START-->
        <div class="row moreitems">
            <!--SMALL ITEM 1 START-->
            <%for(int i = 0 ; i < list.size()  ; i=i+2 ) {%>
            <%for(int j = i%2 ; j < 2 && (i+j)<list.size()  ; j++ ) {%>
            <div class="col-md-6">
                <!--SMALL PRODUCT IMAGE START-->
                
                <div class="col-md-5 text-center">
                    <a href="">
                        <img class="productimg" src="img/christmas_lights_01.jpg" alt="">
                    </a>

                    <!--DISCOUNT TAG-->
                    <!--DISCOUNT TAG END-->
                </div><!--PRODUCT IMAGE END-->

                <!--SMALL PRODUCT DESCRIPTION START-->
                <div class="col-md-7">
                    <h4><a href="/ChristmasLightFinder/SingleListDescription?id=<%=list.get(i+j).get("listingID")%>"><%=list.get(i+j).get("displayName") %></a></h4>
                    <p><%=list.get(i+j).get("address") %></p>
                    <p><%=list.get(i+j).get("city") %></p>
                    <p><%=list.get(i+j).get("state") %></p>
                </div>
            </div><!--SMALL ITEM 1 END-->
          <%}%> 
		 <%}%>
        </div><!--SMALL ITEM 1ST ROW END-->
</div>
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
