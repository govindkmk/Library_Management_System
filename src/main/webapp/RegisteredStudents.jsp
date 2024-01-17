<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.IOException, java.sql.SQLException, model.User, dao.UserDAO, daoimpl.UserDAOImp, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <link rel="icon" href="images/logo.png" type="image/icon type">
    <title>Online Library Management System</title>


    <style>
        .container{
            display: flex;
            width: 65%;
            margin-top: 5%;
        }
        button {
        	margin-right: 10px;
        	width: 70px;
        }
         
        
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg" style="background-color: aliceblue; height: auto;">
        <img src="images/logo.png" class="brand-logo" width="auto" height="70px" >
        <div class="container-fluid" style=" padding-left: 5%;"> 
          <a class="navbar-brand" href="Dashboard.jsp">Dashboard</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Categories
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="AddCategory.jsp">Add Category</a></li>
                  <li><a class="dropdown-item" href="ManageCategory.jsp">Manage Category</a></li>
                </ul>
               </li>
               <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Authors
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="AddAuthor.jsp">Add Author</a></li>
                  <li><a class="dropdown-item" href="ManageAuthor.jsp">Manage Author</a></li>
                </ul>
               </li>
               <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Books
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="AddBook.jsp">Add Book</a></li>
                  <li><a class="dropdown-item" href="ManageBook.jsp">Manage Books</a></li>
                </ul>
               </li>
               <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Issue Books
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="IssueBook.jsp">Issue New Book</a></li>
                  <li><a class="dropdown-item" href="ManageIssuedBook.jsp">Managed Issued Books</a></li>
                </ul>
               </li>
               <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="RegisteredStudents.jsp">Register Students</a>
              </li>
            </ul>
            <a href="AdminLogin.jsp" style="padding-right: 5%;"><button class="btn btn-outline-success" type="submit">Logout</button></a>
          </div>
        </div>
      </nav>
    <h5 style="margin: 15px;">Manage Register Students</h5><hr>
    <%
    	UserDAO userDAO = new UserDAOImp();
    	List<User> users = new ArrayList();
    	users = userDAO.getAllUsers();
    	
    %>
    <div class="container">
        <table class="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Student Name</th>
                <th scope="col">Email</th>
                <th scope="col">Mobile Number</th>
                <th scope="col">Reg Date</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
            <% for(User user : users){ %>
              <tr>
                <th scope="row"><%= user.getId() %></th>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
                <td><%= user.getPhoneNumber() %></td>
                <td><%= user.getRegistrationDate() %></td>
                <td><%= user.getStatus() %></td>
                <td>
                	<a href="EditRegisteredStudents?action=UPDATE&userId=<%= user.getId() %>"><button type="button" class="btn btn-outline-success">Edit</button></a>
                    <a href="DeleteUser?action=DELETE&userId=<%= user.getId() %>"><button type="button" class="btn btn-outline-danger">Delete</button></a>
                </td>
              </tr>
            <%} %>
            </tbody>
          </table>
    </div>
</body>
</html>