package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import daoimpl.*;
import model.*;
/**
 * Servlet implementation class IssueBook
 */
@WebServlet("/IssueBookServlet")
public class IssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//int userId = Integer.parseInt(request.getParameter("user"));
		String userName = request.getParameter("user");
		String bookName = request.getParameter("book");
		
		IssueBookDAO issueBookDAO = new IssueBookDAOImp();
		IssueBook issueBook = new IssueBook();
		UserDAO userDAO = new UserDAOImp();
		BookDAO bookDAO = new BookDAOImp();
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis);
		
		try {
			//User user = userDAO.getUserById(userId);
			User user = userDAO.getUserByName(userName);
			issueBook.setUser(user);
			Book book = bookDAO.getBookByName(bookName);
			issueBook.setBook(book);
			issueBook.setIssueDate(date);
			
			boolean success = issueBookDAO.issueBook(issueBook);
			if(success) {
				response.sendRedirect("ManageIssuedBook.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
