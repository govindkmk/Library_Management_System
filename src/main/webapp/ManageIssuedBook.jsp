<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.IOException, java.sql.SQLException, model.IssueBook, dao.IssueBookDAO, daoimpl.IssueBookDAOImp, java.util.List, java.util.ArrayList"%>
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
    <h5 style="margin: 15px;">Manage Issued Books</h5><hr>
    <%
	    IssueBookDAO issueBookDAO = new IssueBookDAOImp();
		List<IssueBook> issueBooks = new ArrayList();
		
		try {
			issueBooks = issueBookDAO.getAllIssueBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    %>
    <div class="container">
        <table class="table" border="1">
          <thead class="thead">
            <th colspan="8">Issued Books</th>
          </thead>
          <tbody>
            <tr>
              <td>
                <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">Student Name</th>
                      <th scope="col">Book Name</th>
                      <th scope="col">ISBN</th>
                      <th scope="col">Price</th>
                      <th scope="col">Issued Date</th>
                      <th scope="col">Return Date</th>
                      <th scope="col">Action</th>
                    </tr>
                  </thead>
                  <tbody>
                  <% for(IssueBook issueBook : issueBooks){ %>
                    <tr>
                      <th scope="row"><%= issueBook.getId() %></th>
                      <td><%= issueBook.getUser().getName() %></td>
                      <td><%= issueBook.getBook().getName() %></td>
                      <td><%= issueBook.getBook().getIsbnNumber() %></td>
                      <td><%= issueBook.getBook().getPrice() %></td>
                      <td><%= issueBook.getIssueDate() %></td>
                      <td><%= issueBook.getReturnDate() %></td>
                      <td>
                      	<a href="EditIssuedBook?action=UPDATE&issuedBookId=<%= issueBook.getId() %>"><button type="button" class="btn btn-outline-success">Edit</button></a>
                      	<a href="DeleteIssuedBook?action=DELETE&issuedBookId=<%= issueBook.getId() %>"><button type="button" class="btn btn-outline-danger">Delete</button></a>
                      </td>
                    </tr>
                  <%} %>
                  </tbody>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
</body>
</html>