<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*, dao.*, daoimpl.*, java.util.*, java.math.BigInteger"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="images/logo.png" type="image/icon type">
<title>Online Library Management System</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>


    <style>
        .rect{
            height: 200px;
            width: 400px;
            background: #fbfbfb;
            text-align: center;
            position: relative;
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
    <h5 style="margin: 15px;">ADMIN DASHBOARD</h5><hr>
    <%
    	BookDAO bookDAO = new BookDAOImp();
    	List<Book> books = bookDAO.getAllBooks();
    	IssueBookDAO issuedBookDAO = new IssueBookDAOImp();
    	BigInteger totalReturnedBooks = issuedBookDAO.returnedBooks();
    	List<IssueBook> issuedBooks = issuedBookDAO.getAllIssueBooks();
    	UserDAO userDAO = new UserDAOImp();
    	List<User> users = userDAO.getAllUsers();
    	AuthorDAO authorDAO = new AuthorDAOImp();
    	List<Author> authors = authorDAO.getAllAuthors();
    	CategoryDAO categoryDAO = new CategoryDAOImp();
    	List<Category> categories = categoryDAO.getAllCategories();

    	
    %>
    <div class="container">
        <div class="rect">
       		<img src="https://cdn-icons-png.flaticon.com/128/3488/3488924.png?ga=GA1.2.463043727.1692185847&semt=ais">
       		<h3><%= books.size() %></h3>
            <h1>Books Listed</h1>
        </div>
        <div class="rect">
            <img src="https://cdn-icons-png.flaticon.com/128/8599/8599767.png?ga=GA1.2.463043727.1692185847&semt=ais">
            <h3><%= issuedBooks.size() %></h3>
            <h1>Books Issued</h1>
        </div>
        <div class="rect">
            <img src="https://cdn-icons-png.flaticon.com/128/12166/12166624.png?ga=GA1.2.463043727.1692185847&semt=ais">
            <h3><%= totalReturnedBooks %></h3>
            <h1>Books Returned</h1>
        </div>
    </div>
    <div class="container" style="margin-top: 05px;">
        <div class="rect">
            <img src="https://cdn-icons-png.flaticon.com/128/1260/1260930.png?ga=GA1.2.463043727.1692185847&semt=ais">
			<h3><%= users.size() %></h3>
            <h1>Register Users</h1>
        </div>
        <div class="rect">
            <img src="https://cdn-icons-png.flaticon.com/128/1260/1260928.png?ga=GA1.2.463043727.1692185847&semt=ais">
            <h3><%= authors.size() %></h3>
            <h1>Authors Listed</h1>
        </div>
        <div class="rect">
            <img src="https://cdn-icons-png.flaticon.com/128/1259/1259165.png?ga=GA1.2.463043727.1692185847&semt=ais">
            <h3><%= categories.size() %></h3>
            <h1>Categories Listed</h1>
        </div>
    </div>
</body>
</html>
