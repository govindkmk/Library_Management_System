<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.User, dao.UserDAO, daoimpl.UserDAOImp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    <link rel="icon" href="images/logo.png" type="image/icon type">
    <title>Online Library Management System</title>


    <style>
        
        .table{
          border-color: rgb(186, 188, 188);
          width: 40%;
          margin-left: auto;
          margin-right: auto;
          margin-top: 20px;
        } 
        .thead th{
          background-color: rgba(112, 219, 255, 0.3);  
          color: rgb(61, 61, 155);
        }
        td{
          font-weight: 500;
        }
        label{
            margin: 10px;
        }
        .button{
          background-color: rgba(12, 194, 255, 0.3);
          width: 100px;
          height: 40px;
          border-radius: 5px;
        }
        .button:hover{
          background-color: rgb(255, 255, 255);
          outline: auto;
          outline-color: rgba(112, 219, 255, 0.3);
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

    <h5 style="margin: 15px;">My Profile</h5><hr>
	<%
		String email = (String)session.getAttribute("userEmail");
		UserDAO userDAO = new UserDAOImp();
		User user = userDAO.getUserByEmail(email);
	%>
    <div class="container">
      <table class="table" border="1">
        <thead class="thead">
          <th>Details</th>
        </thead>
        <tbody>
          <tr>
            <td>
              <form action="UpdateUser">
	              <label for="">Student ID: <%= user.getId() %></label><br>
	              <label for="">Reg Date: <%= user.getRegistrationDate() %> </label><br>
	              <label for="">Last Updation Date: <%=  user.getUpdationDate() %></label><br>
	              <label for="">Profile Status: <%= user.getStatus() %></label><br>
	          	  <label>Email: <%= user.getEmail()%></label><br>
	              <label for="">Enter Full Name</label><br>
	              <input class="form-control" type="text" name="name" value="<%= user.getName() %>"><br>
                  <label for="">Enter Mobile Number</label><br>
	              <input class="form-control" type="text" name="mobileNumber" value="<%= user.getPhoneNumber() %>"><br>
	              
	              <input type="submit" value="Update Now" class="button">
              </form>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
</body>
</html>