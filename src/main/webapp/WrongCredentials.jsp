<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        body{
            background: #dfe9f5;
        }
        .wrapper{
            width: 330px;
            padding: 2rem 1rem;
            margin: 50px auto;
            background-color: #fff;
            border-radius: 10px;
            text-align: center;
            box-shadow:0 20px 35px rgba(0, 0, 0, 0.1);
        }
        h1{
            font-size: 2rem;
            color: #07001f;
            margin-bottom: 1.2rem;
        }
        form input{
            width: 92%;
            outline: none;
            border: 1px solid #fff;
            padding: 12px 20px;
            margin-bottom: 10px;
            border-radius: 20px;
            background: #e4e4e4;
        }
        .button{
            font-size: 1rem;
            margin-top: 1.8rem;
            padding: 10px 0;
            border-radius: 20px;
            outline: none;
            width: 90%;
            color: #fff;
            cursor: pointer;
            background: rgb(17, 107, 143);
        }
        .button:hover{
            background: rgba(17, 107, 143, 0.877);
        }
        input:focus {
            border: 1px solid rgb(192, 192, 192);
        }
        .terms {
            margin-top: 0.2rem;
        }
        .terms input{
            height: 1em;
            width: 1em;
            vertical-align: middle;
            cursor: pointer;
        }
        .terms label{
            font-size: 0.7rem;
        }
        .terms a{
            color: rgb(17, 107, 143);
            text-decoration: none;
        }
        .member{
            font-size: 0.8rem;
            margin-top: 1.4rem;
            color: #636363;
        }
        .member a{
            color: rgb(17, 107, 143);
            text-decoration: none;
        }
        .recover{
            text-align: right;
            font-size: 0.7rem;
            margin: 0.3rem 1.4rem 0 0;
        }
        .recover a{
            text-decoration: none;
            color: #464647;
        
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
    <div class="wrapper">
        <h1>Confirm Password does not match with Password</h1>
        <form action="UserLogin.jsp">
           	<input type="submit" value="Go Back" class="button">
        </form>
    </div>
</body>
</html>