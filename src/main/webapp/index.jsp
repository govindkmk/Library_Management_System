<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

        <link rel="icon" href="images/logo.png" type="image/icon type">
        <title>Online Library Management System</title>
        
        <style>
        	@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap');
	        * {
	            margin: 0;
	            padding: 0;
	            box-sizing: border-box;
	            font-family: "Poppins", sans-serif;
	        }
	        .carousel{
	            width: 50%;
	            display: block;
	            margin: auto;
	            margin-top: 8px;
	        }
	        .carousel .carousel-item {
	            transition-duration: 2s;            
	        }

    	</style>	
    </head>
    <body>
        <nav class="navbar navbar-expand-lg" style="background-color: aliceblue; height: auto;">
		    <img src="images/logo.png" class="brand-logo" width="auto" height="70px">
		    <a style="color: black; padding-left: 50px; padding-right: 15%; font-size: 30px; font-family: serif;">Online Library Management System</a>
		    <a class="navbar-brand" href="index.jsp" style="padding-right: 2%; padding-left: 77px">Home</a>
		    <a href="AdminLogin.jsp" style="padding-right: 1%;"><button class="btn btn-success btn-lg" type="submit">Admin Login</button></a>
		    <a href="UserLogin.jsp" style="padding-right: 1%;"><button class="btn btn-success btn-lg" type="submit">Student Login</button></a>
		    <a href="UserSignup.jsp"><button class="btn btn-success btn-lg" type="submit">Student Signup</button></a>

  		</nav>
	    <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
	        <div class="carousel-inner">
	          <div class="carousel-item">
	            <img src="images/pic1.png" class="d-block w-100" width="400px" height="600px">
	          </div>
	          <div class="carousel-item active">
	            <img src="images/pic2.png" class="d-block w-100" width="400px" height="600px">
	          </div>
	          <div class="carousel-item">
	            <img src="images/pic3.png" class="d-block w-100" width="400px" height="600px">
	          </div>
	        </div>
	    </div>
        
    
   	</body>
    
</html>