<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*, dao.*, daoimpl.*, java.util.*, java.math.BigInteger"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    

    <link rel="icon" href="images/logo.png" type="image/icon type">
    <title>Online Library Management System</title>

    <style>
        .rect{
            height: 225px;
            width: 450px;
            background: #fbfbfb;
            text-align: center;
            position: relative;
        }
        .h1{
            position: absolute;
            left: 50%;
            transform: translate(-50%, 150%);
        }
        .container{
            display: flex;
            margin-top: 0%;
            text-align: center;
        }
        .container div{
            margin: 20px;
            outline: auto;
            outline-color: rgb(29, 21, 68);
            padding-top: 20px;
            margin-top: 90px;
            
        }
        img{
        	width: 80px;
        	height: 80px;
        }
        h3{
        	font-family: "Times New Roman", Times, serif;
        	margin-top: 7px;
        	font-weight: bold;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg" style="background-color: aliceblue; height: auto;">
        <img src="images/logo.png" class="brand-logo" width="auto" height="70px" >
        <div class="container-fluid" style=" padding-left: 5%;"> 
          <a class="navbar-brand" href="UserDashboard.jsp">Dashboard</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
               <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Account
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="UserProfile.jsp">My Profile</a></li>
                  <li><a class="dropdown-item" href="UserChangePassword.jsp">Change Password</a></li>
                </ul>
               </li>
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="UserManageIssuedBooks.jsp">Issued Books</a>
              </li>
            </ul>
            <a href="UserLogin.jsp" style="padding-right: 5%;"><button class="btn btn-outline-success" type="submit">Logout</button></a>
          </div>
        </div>
    </nav>
    <%
	    String email = (String)session.getAttribute("userEmail");
	    
		UserDAO userDAO = new UserDAOImp();
		User user = userDAO.getUserByEmail(email);
		int userId = user.getId();
		
		IssueBookDAO issueBookDAO = new IssueBookDAOImp();
		
		List<IssueBook> userTotalIssuedBooks = issueBookDAO.getUserTotalIssuedBooks(userId);
		BigInteger userTotalBooksNotReturned = issueBookDAO.userNotReturnedBooks(userId);
    %>
    <h5 style="margin: 15px;">STUDENT  DASHBOARD</h5><hr>
    <div class="container">
        <div class="rect">
            <img src="https://cdn-icons-png.flaticon.com/128/8599/8599767.png?ga=GA1.2.463043727.1692185847&semt=ais">
            <h3><%= userTotalIssuedBooks.size() %></h3>
            <h1>Books Issued</h1>
        </div>
        <div class="rect">
            <img src="https://cdn-icons-png.flaticon.com/128/12166/12166624.png?ga=GA1.2.463043727.1692185847&semt=ais">
            <h3><%= userTotalBooksNotReturned %></h3>
            <h1>Books Not Returned Yet</h1>
        </div>
    </div>
    
</body>
</html>
