<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>LightsFinder - Add Listings</title>
	
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
	  var validateFormCount = 0;
	  
	//validation for DisplayName textbox
	  function validateDisplayName(displaynameInput)
	  {
	  	var onlyAlphabhet_validator = /^[a-zA-Z\s]*$/;
	  		
	  	if(!onlyAlphabhet_validator.test(displaynameInput))
	  	{
	  		document.getElementById("dname").innerHTML = "Display Name should have only letters";
	  		validateFormCount++;
	  		document.getElementById("displayname").value = "";
	  	}
	  }
	  
	  //validation for Address textbox
	  function addressValidate(addressInput)
	  {
		var alphanumeric_validator = /^[a-zA-Z\s\d\/]*\d[a-zA-Z\s\d\/]*$/;
			
		if( !alphanumeric_validator.test(addressInput) )
		{
				document.getElementById("addr").innerHTML = "Address field should contain only alphanumeric characters";
				validateFormCount++;
				document.getElementById("address").value = "";
		}
	   }
	  
	  //validation for City textbox
	  function cityValidate(cityInput)
	  {
		 var onlyAlphabhet_validator = /^[a-zA-Z]+$/;
		 
		 if( !onlyAlphabhet_validator.test(cityInput))
		 {
			 document.getElementById("ct").innerHTML = "City field should contain only alphabets";
			 validateFormCount++;
			 document.getElementById("city").value = "";
		 }
	  }
	  
	  function stateValidate(stateInput)
	  {
		 var onlyAlphabhet_validator = /^[a-zA-Z]+$/;
		 
		 if( !onlyAlphabhet_validator.test(stateInput))
		 {
			 document.getElementById("st").innerHTML = "State field should contain only alphabets";
			 validateFormCount++;
			 document.getElementById("state").value = "";
		 }
	  }
	  
	  /* function Validate()
	  {
		  //alert('in validate');
		  var displayName = document.getElementById("displayname").value;
		  //alert(displayName);
		  var address = document.getElementById("address").value;
		  var city = document.getElementById("city").value;
		  var state = document.getElementById("state").value;
		  var isValid = true;
		
		  document.getElementById("dname").innerHTML = "";
		  document.getElementById("addr").innerHTML = "";
		  document.getElementById("ct").innerHTML = "";
		  document.getElementById("st").innerHTML = "";
		  
		  validateDisplayName(displayName);
		  addressValidate(address);
		  cityValidate(city);
		  stateValidate(state);
		  
		  if(validateFormCount > 0)
		  {
			isValid = false;
		  }
		  else
		  {
			 isValid = true;
		  }
		  //alert(isValid);
		  return isValid;
	  }
	  
	  function Reset()
	  {
		//alert('in reset');
		document.getElementById("dname").innerHTML = "";
		document.getElementById("addr").innerHTML = "";
		document.getElementById("ct").innerHTML = "";
		document.getElementById("st").innerHTML = "";
	  } */
	  
  
  </script>
</head>
<body>
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
                        <li><a href="#" class="active">Add Listings</a></li>
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
     </div>
    <!--HERO SECTION END-->
    
    <!-- ===========================
    PRODUCTS SECTION
    =========================== -->
    <div id="products" class="container">

        <!--SECTIONHEAD START-->
        <div class="sectionhead text-center">
            <h2>Add a New Listing</h2>
            <hr>
        </div><!--SECTIONHEAD END-->

        <hr><!--SEPARETOR LINE-->
        <div class="row">
        	<div class="col-md-6 col-md-offset-3">
            	<form name="addlistings" method="post" autocomplete="on" action="AddListings" enctype="multipart/form-data">
                	<div class="form-group">
                        <label for="">Display Name</label>
                        <input type="text" class="form-control" id="displayname" required name="displayname" placeholder="Only alphabets" autofocus>
                    	<!-- <span class="error" id="dname"></span> -->
                    </div> 
                    <div class="form-group">
                        <label for="">Street Address</label>
                        <input type="text" class="form-control" id="address" required name="address" placeholder="Street address Apartment">
                        <!-- <span class="error" id="addr"></span> -->
                    </div>
                    <div class="form-group">
                        <label for="">City</label>
                        <input type="text" class="form-control" id="city" required name="city">
                        <!-- <span class="error" id="ct"></span> -->
                    </div>
                    <div class="form-group">
                        <label for="">State</label>
                        <input type="text" class="form-control" id="state" required name="state" placeholder="">
                        <!-- <span class="error" id="st"></span> -->
                    </div>
                    <div class="form-group">
                        <label for="">Description</label>
                        <textarea class="form-control" maxlength="1000" 
                        		name="addcomments" placeholder="any specific instructions"></textarea>
                    </div>
                    <div class="form-group">
                    	<label for="">Upload Image</label>
                    	<input type="file" name="photo"/><span><b>Maximum Image Size: 1Gb</b></span>
                    </div>
                     <!-- <button type="submit" class="btn btn-default">Add Listing</button> -->
                     <input type="submit" id="submit" class="btn btn-default" value="Add Listing"/>
                     <input type="reset" class="btn btn-default pull-right" onclick="Reset()"/>
                </form>
            </div>
        </div>
    </div><!--PRODUCTS SECTION END-->
    
    <!-- ===========================
    SUBSCRIBE SECTION
    =========================== -->
    <div id="subscribe">
        <div class="darkoverlay">
            <div class="container text-center">
                <img class="santaicon wow tada infinite" data-wow-duration="20s" src="img/santa-sm.png" alt="">
                <!--MAILCHIMP FORM START-->  
                <div class="mailchimp"></div>
            </div><!--SUBSCRIBE CONTAINER END-->
        </div><!--OVERLAY END-->
    </div><!--SUBSCRIBE SECTION END-->
    
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